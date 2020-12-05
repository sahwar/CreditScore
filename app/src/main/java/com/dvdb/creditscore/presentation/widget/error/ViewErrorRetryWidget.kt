package com.dvdb.creditscore.presentation.widget.error

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.dvdb.creditscore.databinding.ErrorRetryLayoutBinding

class ViewErrorRetryWidget : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var onErrorRetryClick: (() -> Unit)? = null

    private val binding = ErrorRetryLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.action.setOnClickListener {
            onErrorRetryClick?.invoke()
        }
    }
}