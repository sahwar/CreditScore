package com.dvdb.creditscore.api.model.response

import com.dvdb.creditscore.api.model.DTOOverviewCoachingSummary
import com.dvdb.creditscore.api.model.DTOOverviewCreditReportInfo
import com.dvdb.creditscore.api.model.response.base.DTOResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DTOResponseOverview(
    @Json(name = "accountIDVStatus") val accountIDVStatus: String? = null,
    @Json(name = "creditReportInfo") val creditReportInfo: DTOOverviewCreditReportInfo? = null,
    @Json(name = "dashboardStatus") val dashboardStatus: String? = null,
    @Json(name = "personaType") val personaType: String? = null,
    @Json(name = "coachingSummary") val coachingSummary: DTOOverviewCoachingSummary? = null,
    @Json(name = "augmentedCreditScore") val augmentedCreditScore: Any? = null
) : DTOResponse()