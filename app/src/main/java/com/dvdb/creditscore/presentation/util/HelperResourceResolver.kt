package com.dvdb.creditscore.presentation.util

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Px
import androidx.annotation.StringRes

interface HelperResourceResolver {
    fun getString(@StringRes stringRes: Int): String?

    fun getColor(@ColorRes colorRes: Int): Int?

    fun getDimension(@DimenRes dimenRes: Int): Float?

    @Px
    fun getDimensionPixelSize(@DimenRes dimenRes: Int): Int?
}