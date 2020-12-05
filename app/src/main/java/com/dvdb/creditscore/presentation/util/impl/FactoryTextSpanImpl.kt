package com.dvdb.creditscore.presentation.util.impl

import android.content.Context
import android.text.style.TextAppearanceSpan
import com.dvdb.creditscore.presentation.util.FactoryTextSpan
import java.lang.ref.WeakReference

class FactoryTextSpanImpl(
    context: Context
) : FactoryTextSpan {
    private val contextRef: WeakReference<Context> = WeakReference(context)

    override fun createTextAppearanceSpan(appearanceId: Int): TextAppearanceSpan? {
        return contextRef.get()?.let {
            TextAppearanceSpan(it, appearanceId)
        }
    }
}