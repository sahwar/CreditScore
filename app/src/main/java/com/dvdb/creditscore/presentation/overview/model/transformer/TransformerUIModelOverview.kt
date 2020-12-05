package com.dvdb.creditscore.presentation.overview.model.transformer

import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.presentation.overview.model.UIModelOverview
import com.dvdb.creditscore.presentation.overview.model.UIModelOverviewScoreBandType

fun EntityOverview.transform(): UIModelOverview {
    val scoreBandType = UIModelOverviewScoreBandType.fromInt(scoreBandType.value)
    return UIModelOverview(
        score = score,
        maxScore = maxScore,
        progressCirclePercentage = score.toFloat() / maxScore.toFloat(),
        progressCircleColorRes = scoreBandType.colorRes
    )
}