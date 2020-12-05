package com.dvdb.creditscore.presentation.overview.model

import androidx.annotation.ColorRes
import com.dvdb.creditscore.R

enum class UIModelOverviewScoreBandType(
    val value: Int,
    @ColorRes val colorRes: Int
) {
    UNKNOWN(-1, R.color.grey_700),
    VERY_POOR(1, R.color.red_800),
    POOR(2, R.color.orange_800),
    FAIR(3, R.color.yellow_600),
    GOOD(4, R.color.green_200),
    VERY_GOOD(5, R.color.green_400),
    EXCELLENT(6, R.color.green_800);

    companion object {
        fun fromInt(value: Int): UIModelOverviewScoreBandType =
            values().firstOrNull { type -> type.value == value } ?: UNKNOWN
    }
}