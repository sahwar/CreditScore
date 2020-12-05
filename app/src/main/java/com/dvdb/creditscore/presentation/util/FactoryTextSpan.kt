package com.dvdb.creditscore.presentation.util

import android.text.style.TextAppearanceSpan
import androidx.annotation.IdRes

interface FactoryTextSpan {
    fun createTextAppearanceSpan(@IdRes appearanceId: Int): TextAppearanceSpan?
}