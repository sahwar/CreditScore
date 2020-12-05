package com.dvdb.creditscore.presentation.util.impl

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Px
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.dvdb.creditscore.presentation.util.HelperResourceResolver
import java.lang.ref.WeakReference

class HelperResourceResolverImpl(
    context: Context?
) : HelperResourceResolver {
    private val contextRef: WeakReference<Context> = WeakReference(context)

    override fun getString(@StringRes stringRes: Int): String? {
        return contextRef.get()?.getString(stringRes)
    }

    override fun getColor(@ColorRes colorRes: Int): Int? {
        return contextRef.get()?.let { context ->
            ContextCompat.getColor(context, colorRes)
        }
    }

    override fun getDimension(@DimenRes dimenRes: Int): Float? {
        return contextRef.get()?.resources?.getDimension(dimenRes)
    }

    @Px
    override fun getDimensionPixelSize(@DimenRes dimenRes: Int): Int? {
        return contextRef.get()?.resources?.getDimensionPixelSize(dimenRes)
    }
}