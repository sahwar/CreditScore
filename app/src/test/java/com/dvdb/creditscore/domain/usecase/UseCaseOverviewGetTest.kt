package com.dvdb.creditscore.domain.usecase

import com.dvdb.creditscore.api.model.DTOOverviewCreditReportInfo
import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.domain.helper.FakeOverviewRepository
import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.domain.model.EntityOverviewScoreBandType
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.usecase.impl.UseCaseOverviewGet
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UseCaseOverviewGetTest {

    @Test
    fun execute_nonNullValues() = runBlocking {
        val scoreBandValue = 5
        val expectedScoreBandType = EntityOverviewScoreBandType.fromInt(scoreBandValue)
        val expectedEntityResponseOverview = EntityResponseOverview(
            overview = EntityOverview(
                score = 504,
                minScore = 0,
                maxScore = 700,
                scoreBandType = expectedScoreBandType
            )
        )

        val useCase = UseCaseOverviewGet.Factory(
            FakeOverviewRepository(
                DTOResponseOverview(
                    creditReportInfo = DTOOverviewCreditReportInfo(
                        score = expectedEntityResponseOverview.overview.score,
                        minScoreValue = expectedEntityResponseOverview.overview.minScore,
                        maxScoreValue = expectedEntityResponseOverview.overview.maxScore,
                        scoreBand = scoreBandValue,
                    )
                )
            )
        ).create()
        val actualEntityResponseOverview = useCase.execute()

        Assert.assertEquals(expectedEntityResponseOverview, actualEntityResponseOverview)
    }
}