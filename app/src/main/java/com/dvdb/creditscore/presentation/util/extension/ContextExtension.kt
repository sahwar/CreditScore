package com.dvdb.creditscore.presentation.util.extension

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes

fun Context.resolveAttribute(
    @AttrRes attr: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attr, typedValue, resolveRefs)
    return typedValue.data
}