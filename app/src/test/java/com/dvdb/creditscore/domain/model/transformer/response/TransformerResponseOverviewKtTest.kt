package com.dvdb.creditscore.domain.model.transformer.response

import com.dvdb.creditscore.api.model.DTOOverviewCreditReportInfo
import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.domain.helper.HelperEntityDefaults
import com.dvdb.creditscore.domain.model.EntityOverviewScoreBandType
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import org.junit.Assert
import org.junit.Test

class TransformerResponseOverviewKtTest {

    @Test
    fun transform_nonNullValues() {
        // Expected values
        val expectedScore = 504
        val expectedMinScore = 0
        val expectedMaxScore = 700
        val scoreBandValue = 5
        val expectedScoreBandType = EntityOverviewScoreBandType.fromInt(scoreBandValue)

        // Input response
        val dtoOverviewResponse = DTOResponseOverview(
            creditReportInfo = DTOOverviewCreditReportInfo(
                score = expectedScore,
                minScoreValue = expectedMinScore,
                maxScoreValue = expectedMaxScore,
                scoreBand = scoreBandValue
            )
        )

        // Output response transformed from input response
        val actualEntityOverviewResponse = dtoOverviewResponse.transform()

        actualEntityOverviewResponse.assertValues(
            expectedScore,
            expectedMinScore,
            expectedMaxScore,
            expectedScoreBandType
        )
    }

    @Test
    fun transform_nullValues_assignDefaults() {
        // Expected values
        val expectedScore = HelperEntityDefaults.INTEGER
        val expectedMinScore = HelperEntityDefaults.INTEGER
        val expectedMaxScore = HelperEntityDefaults.INTEGER
        val expectedScoreBandType = EntityOverviewScoreBandType.UNKNOWN

        // Input response
        val dtoOverviewResponse = DTOResponseOverview()

        // Output response transformed from input response
        val actualEntityOverviewResponse = dtoOverviewResponse.transform()

        actualEntityOverviewResponse.assertValues(
            expectedScore,
            expectedMinScore,
            expectedMaxScore,
            expectedScoreBandType
        )
    }

    private fun EntityResponseOverview.assertValues(
        expectedScore: Int,
        expectedMinScore: Int,
        expectedMaxScore: Int,
        expectedScoreBandType: EntityOverviewScoreBandType
    ) {
        Assert.assertEquals(expectedScore, overview.score)
        Assert.assertEquals(expectedMinScore, overview.minScore)
        Assert.assertEquals(expectedMaxScore, overview.maxScore)
        Assert.assertEquals(expectedScoreBandType, overview.scoreBandType)
    }
}