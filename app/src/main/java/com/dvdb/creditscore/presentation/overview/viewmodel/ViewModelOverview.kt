package com.dvdb.creditscore.presentation.overview.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.usecase.UseCase
import com.dvdb.creditscore.domain.usecase.UseCaseFactory
import com.dvdb.creditscore.presentation.overview.model.UIModelOverview
import com.dvdb.creditscore.presentation.overview.model.transformer.transform
import com.dvdb.creditscore.presentation.util.model.UIModelDataState
import com.dvdb.creditscore.shared.extension.exhaustive
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ViewModelOverview @ViewModelInject constructor(
    useCaseOverviewGetFactory: UseCaseFactory<EntityResponseOverview>
) : ViewModel() {
    private val useCaseOverviewGet: UseCase<EntityResponseOverview> =
        useCaseOverviewGetFactory.create()

    private val _dataState: MutableLiveData<UIModelDataState<UIModelOverview>> = MutableLiveData()
    val dataState: LiveData<UIModelDataState<UIModelOverview>>
        get() = _dataState

    fun setStateEvent(event: StateEvent) {
        when (event) {
            is StateEvent.None -> {
            }

            is StateEvent.GetOverview -> getOverview()
        }.exhaustive
    }

    private fun getOverview() {
        launchDataLoad {
            val response = useCaseOverviewGet.execute()
            if (response.isSuccessful) {
                _dataState.value = UIModelDataState.Success(response.overview.transform())
            } else {
                _dataState.value =
                    UIModelDataState.Error(IllegalStateException(response.message))
            }
        }
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            _dataState.value = UIModelDataState.Loading
            try {
                block()
            } catch (ex: Exception) {
                _dataState.value = UIModelDataState.Error(ex)
            }
        }
    }

    sealed class StateEvent {
        object None : StateEvent()
        object GetOverview : StateEvent()
    }
}