package com.dvdb.creditscore.domain.model

data class EntityOverview(
    val score: Int,
    val minScore: Int,
    val maxScore: Int,
    val scoreBandType: EntityOverviewScoreBandType
)