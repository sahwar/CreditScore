package com.dvdb.creditscore.domain.model

enum class EntityOverviewScoreBandType(val value: Int) {
    UNKNOWN(-1),
    VERY_POOR(1),
    POOR(2),
    FAIR(3),
    GOOD(4),
    VERY_GOOD(5),
    EXCELLENT(6);

    companion object {
        fun fromInt(value: Int): EntityOverviewScoreBandType =
            values().firstOrNull { type -> type.value == value } ?: UNKNOWN
    }
}