package com.dvdb.creditscore.api.repository.impl

import com.dvdb.creditscore.api.model.DTOOverviewCreditReportInfo
import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.network.service.ApiService
import com.dvdb.creditscore.api.repository.RepositoryOverview
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class RepositoryOverviewImplTest {

    @Test
    fun getOverview() = runBlocking {
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

        val repository: RepositoryOverview =
            RepositoryOverviewImpl(FakeApiService(expectedOverviewResponse))
        val actualOverviewResponse = repository.getOverview()

        Assert.assertEquals(expectedOverviewResponse, actualOverviewResponse)
    }

    private class FakeApiService(
        private val response: DTOResponseOverview
    ) : ApiService {
        override suspend fun getOverview(): DTOResponseOverview = response
    }
}