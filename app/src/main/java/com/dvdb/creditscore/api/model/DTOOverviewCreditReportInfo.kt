package com.dvdb.creditscore.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DTOOverviewCreditReportInfo(
    @Json(name = "score") val score: Int? = null,
    @Json(name = "scoreBand") val scoreBand: Int? = null,
    @Json(name = "clientRef") val clientRef: String? = null,
    @Json(name = "status") val status: String? = null,
    @Json(name = "maxScoreValue") val maxScoreValue: Int? = null,
    @Json(name = "minScoreValue") val minScoreValue: Int? = null,
    @Json(name = "monthsSinceLastDefaulted") val monthsSinceLastDefaulted: Int? = null,
    @Json(name = "hasEverDefaulted") val hasEverDefaulted: Boolean? = null,
    @Json(name = "monthsSinceLastDelinquent") val monthsSinceLastDelinquent: Int? = null,
    @Json(name = "hasEverBeenDelinquent") val hasEverBeenDelinquent: Boolean? = null,
    @Json(name = "percentageCreditUsed") val percentageCreditUsed: Int? = null,
    @Json(name = "percentageCreditUsedDirectionFlag") val percentageCreditUsedDirectionFlag: Int? = null,
    @Json(name = "changedScore") val changedScore: Int? = null,
    @Json(name = "currentShortTermDebt") val currentShortTermDebt: Int? = null,
    @Json(name = "currentShortTermNonPromotionalDebt") val currentShortTermNonPromotionalDebt: Int? = null,
    @Json(name = "currentShortTermCreditLimit") val currentShortTermCreditLimit: Int? = null,
    @Json(name = "currentShortTermCreditUtilisation") val currentShortTermCreditUtilisation: Int? = null,
    @Json(name = "changeInShortTermDebt") val changeInShortTermDebt: Int? = null,
    @Json(name = "currentLongTermDebt") val currentLongTermDebt: Int? = null,
    @Json(name = "currentLongTermNonPromotionalDebt") val currentLongTermNonPromotionalDebt: Int? = null,
    @Json(name = "currentLongTermCreditLimit") val currentLongTermCreditLimit: Any? = null,
    @Json(name = "currentLongTermCreditUtilisation") val currentLongTermCreditUtilisation: Any? = null,
    @Json(name = "changeInLongTermDebt") val changeInLongTermDebt: Int? = null,
    @Json(name = "numPositiveScoreFactors") val numPositiveScoreFactors: Int? = null,
    @Json(name = "numNegativeScoreFactors") val numNegativeScoreFactors: Int? = null,
    @Json(name = "equifaxScoreBand") val equifaxScoreBand: Int? = null,
    @Json(name = "equifaxScoreBandDescription") val equifaxScoreBandDescription: String? = null,
    @Json(name = "daysUntilNextReport") val daysUntilNextReport: Int? = null
)