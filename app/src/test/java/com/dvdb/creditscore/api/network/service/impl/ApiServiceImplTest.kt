package com.dvdb.creditscore.api.network.service.impl

import com.dvdb.creditscore.api.model.DTOOverviewCreditReportInfo
import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.network.service.ApiService
import com.dvdb.creditscore.api.network.service.overview.ApiServiceOverview
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class ApiServiceImplTest {

    @Test
    fun getOverview_bodyMapped() = runBlocking {
        val expectedOverviewResponse = DTOResponseOverview(
            accountIDVStatus = "PASS",
            creditReportInfo = DTOOverviewCreditReportInfo(
                score = 504,
                minScoreValue = 0,
                maxScoreValue = 700
            ),
            dashboardStatus = "PASS",
            personaType = "INEXPERIENCED"
        )

        val repository: ApiService = ApiServiceImpl(
            ApiServiceOverviewFake(
                Response.success(expectedOverviewResponse)
            )
        )
        val actualOverviewResponse = repository.getOverview()

        Assert.assertEquals(expectedOverviewResponse, actualOverviewResponse)
    }

    @Test
    fun getOverview_httpPropertiesMapped() = runBlocking {
        val expectedStatusCode = 200
        val expectedMessage = "Response.success()"
        val expectedIsSuccessful = true

        val repository: ApiService = ApiServiceImpl(
            ApiServiceOverviewFake(
                Response.success(
                    expectedStatusCode,
                    DTOResponseOverview()
                )
            )
        )
        val actualOverviewResponse = repository.getOverview()

        Assert.assertEquals(expectedStatusCode, actualOverviewResponse.statusCode)
        Assert.assertEquals(expectedMessage, actualOverviewResponse.message)
        Assert.assertEquals(expectedIsSuccessful, actualOverviewResponse.isSuccessful)
    }

    private class ApiServiceOverviewFake(
        private val response: Response<DTOResponseOverview>
    ) : ApiServiceOverview {
        override suspend fun getOverview(): Response<DTOResponseOverview> = response
    }
}