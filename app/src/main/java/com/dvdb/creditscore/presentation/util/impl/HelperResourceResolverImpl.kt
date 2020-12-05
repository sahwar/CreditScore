package com.dvdb.creditscore.presentation.util.impl

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import com.dvdb.creditscore.presentation.util.HelperResourceResolver
import java.lang.ref.WeakReference

class HelperResourceResolverImpl(
    context: Context
) : HelperResourceResolver {
    private val contextRef: WeakReference<Context> = WeakReference(context)

    override fun getString(stringRes: Int, vararg formatArg: Any): String? {
        return if (formatArg.isEmpty()) {
            contextRef.get()?.getString(stringRes)
        } else {
            contextRef.get()?.getString(stringRes, *formatArg)
        }
    }

    override fun getColor(colorRes: Int): Int? {
        return contextRef.get()?.let { context ->
            ContextCompat.getColor(context, colorRes)
        }
    }

    override fun getDimension(dimenRes: Int): Float? {
        return contextRef.get()?.resources?.getDimension(dimenRes)
    }

    override fun getDimensionPixelSize(dimenRes: Int): Int? {
        return contextRef.get()?.resources?.getDimensionPixelSize(dimenRes)
    }

    override fun getResourceIdFromAttribute(attrRes: Int): Int? {
        return contextRef.get()?.resolveAttribute(attrRes)
    }

    private fun Context.resolveAttribute(
        @AttrRes attr: Int,
        typedValue: TypedValue = TypedValue(),
        resolveRefs: Boolean = true
    ): Int {
        theme.resolveAttribute(attr, typedValue, resolveRefs)
        return typedValue.data
    }
}