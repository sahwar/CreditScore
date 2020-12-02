package com.dvdb.creditscore.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DTOOverviewCoachingSummary(
    @Json(name = "activeTodo") val activeTodo: Boolean? = null,
    @Json(name = "activeChat") val activeChat: Boolean? = null,
    @Json(name = "numberOfTodoItems") val numberOfTodoItems: Int? = null,
    @Json(name = "numberOfCompletedTodoItems") val numberOfCompletedTodoItems: Int? = null,
    @Json(name = "selected") val selected: Boolean? = null
)