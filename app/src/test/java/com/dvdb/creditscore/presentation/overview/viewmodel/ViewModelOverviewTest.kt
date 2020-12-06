package com.dvdb.creditscore.presentation.overview.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dvdb.creditscore.FakeUseCaseFactory
import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.domain.model.EntityOverviewScoreBandType
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.presentation.overview.model.UIModelOverview
import com.dvdb.creditscore.presentation.overview.model.transformer.transform
import com.dvdb.creditscore.presentation.util.model.UIModelDataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ViewModelOverviewTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Test
    fun setStateEvent_none_unchangedDataState() {
        // Given
        val useCaseOverviewGetFactory = FakeUseCaseFactory {
            createEntityOverviewResponse()
        }
        val viewModel = ViewModelOverview(useCaseOverviewGetFactory)
        val expectedDataState = viewModel.dataState.value

        // When
        viewModel.setStateEvent(ViewModelOverview.StateEvent.None)

        // Then
        Assert.assertEquals(expectedDataState, viewModel.dataState.value)
    }

    @Test
    fun setStateEvent_getOverview_loadingDataState() = runBlocking {
        // Given
        val useCaseOverviewGetFactory = FakeUseCaseFactory {
            createEntityOverviewResponse()
        }
        val viewModel = ViewModelOverview(useCaseOverviewGetFactory)
        val expectedDataState = UIModelDataState.Loading

        // When
        val actualDataStates = mutableListOf<UIModelDataState<UIModelOverview>>()
        viewModel.dataState.observeForever { dataState ->
            actualDataStates.add(dataState)
        }
        viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)

        // Then
        val actualDataState = actualDataStates[0]
        Assert.assertEquals(expectedDataState, actualDataState)
    }

    @Test
    fun setStateEvent_getOverview_successfulResponse_successDataState() = runBlocking {
        // Given
        val expectedResponse = createEntityOverviewResponse()
        val useCaseOverviewGetFactory = FakeUseCaseFactory {
            expectedResponse
        }
        val viewModel = ViewModelOverview(useCaseOverviewGetFactory)
        val expectedDataState =
            UIModelDataState.Success(expectedResponse.overview.transform())

        // When
        val actualDataStates = mutableListOf<UIModelDataState<UIModelOverview>>()
        viewModel.dataState.observeForever { dataState ->
            actualDataStates.add(dataState)
        }
        viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)

        // Then
        val actualDataState = actualDataStates[1]
        Assert.assertEquals(expectedDataState, actualDataState)
    }

    @Test
    fun setStateEvent_getOverview_unsuccessfulResponse_errorDataState() = runBlocking {
        // Given
        val response = createEntityOverviewResponse(isSuccessful = false)
        val useCaseOverviewGetFactory = FakeUseCaseFactory {
            response
        }
        val viewModel = ViewModelOverview(useCaseOverviewGetFactory)

        // When
        val actualDataStates = mutableListOf<UIModelDataState<UIModelOverview>>()
        viewModel.dataState.observeForever { dataState ->
            actualDataStates.add(dataState)
        }
        viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)

        // Then
        val actualDataState = actualDataStates[1]
        Assert.assertTrue(actualDataState is UIModelDataState.Error)
    }

    @Test
    fun setStateEvent_getOverview_exceptionThrown_errorDataState() = runBlocking {
        // Given
        val useCaseOverviewGetFactory = FakeUseCaseFactory {
            error(String())
        }
        val viewModel = ViewModelOverview(useCaseOverviewGetFactory)

        // When
        val actualDataStates = mutableListOf<UIModelDataState<UIModelOverview>>()
        viewModel.dataState.observeForever { dataState ->
            actualDataStates.add(dataState)
        }
        viewModel.setStateEvent(ViewModelOverview.StateEvent.GetOverview)

        // Then
        val actualDataState = actualDataStates[1]
        Assert.assertTrue(actualDataState is UIModelDataState.Error)
    }

    private fun createEntityOverviewResponse(
        isSuccessful: Boolean = true,
        message: String = String()
    ): EntityResponseOverview {
        return EntityResponseOverview(
            EntityOverview(
                score = 0,
                minScore = 0,
                maxScore = 0,
                scoreBandType = EntityOverviewScoreBandType.UNKNOWN
            )
        ).apply {
            this.isSuccessful = isSuccessful
            this.message = message
        }
    }
}