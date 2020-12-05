package com.dvdb.creditscore.presentation.overview.model.transformer

import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.domain.model.EntityOverviewScoreBandType
import com.dvdb.creditscore.presentation.overview.model.UIModelOverviewScoreBandType
import org.junit.Assert
import org.junit.Test

class TransformerUIModelOverviewKtTest {

    @Test
    fun transform_progressCirclePercentage() {
        val score = 504
        val maxScore = 700
        val expectedProgressCirclePercentage = score.toFloat() / maxScore.toFloat()
        val entityOverview = EntityOverview(
            score = score,
            minScore = 0,
            maxScore = maxScore,
            scoreBandType = EntityOverviewScoreBandType.UNKNOWN
        )

        val actualProgressCirclePercentage = entityOverview.transform().progressCirclePercentage

        Assert.assertEquals(expectedProgressCirclePercentage, actualProgressCirclePercentage)
    }

    @Test
    fun transform_progressCircleColorRes() {
        val expectedProgressCircleColorRes = UIModelOverviewScoreBandType.GOOD.colorRes
        val entityOverview = EntityOverview(
            score = 504,
            minScore = 0,
            maxScore = 700,
            scoreBandType = EntityOverviewScoreBandType.GOOD
        )

        val actualProgressCircleColorRes = entityOverview.transform().progressCircleColorRes

        Assert.assertEquals(expectedProgressCircleColorRes, actualProgressCircleColorRes)
    }
}