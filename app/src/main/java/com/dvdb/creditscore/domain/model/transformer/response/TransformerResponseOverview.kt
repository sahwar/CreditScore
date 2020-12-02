package com.dvdb.creditscore.domain.model.transformer.response

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.domain.model.EntityOverview
import com.dvdb.creditscore.domain.model.EntityOverviewScoreBandType
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.model.transformer.response.base.TransformerResponse

fun DTOResponseOverview.transform(): EntityResponseOverview {
    val creditReportInfo = this@transform.creditReportInfo
    return EntityResponseOverview(
        overview = EntityOverview(
            score = creditReportInfo?.score ?: -1,
            minScore = creditReportInfo?.minScoreValue ?: -1,
            maxScore = creditReportInfo?.maxScoreValue ?: -1,
            scoreBandType = EntityOverviewScoreBandType.fromInt(creditReportInfo?.scoreBand ?: -1)
        )
    ).apply {
        TransformerResponse.transform(
            dtoResponse = this@transform,
            entityResponse = this
        )
    }
}