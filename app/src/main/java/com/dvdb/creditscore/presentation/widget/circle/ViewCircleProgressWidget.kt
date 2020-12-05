package com.dvdb.creditscore.presentation.widget.circle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.dvdb.creditscore.R
import com.dvdb.creditscore.presentation.util.HelperResourceResolver
import com.dvdb.creditscore.presentation.util.impl.HelperResourceResolverImpl
import com.dvdb.creditscore.presentation.widget.circle.helper.HelperProgressCircleDimensions

class ViewCircleProgressWidget : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val helperResourceResolver: HelperResourceResolver = HelperResourceResolverImpl(
        context
    )
    private val helperDimensions = HelperProgressCircleDimensions(
        helperResourceResolver
    )

    private val backgroundPaint = Paint().apply {
        helperResourceResolver.getResourceIdFromAttribute(R.attr.colorOnBackground)?.let { color ->
            this.color = color
        }
        style = Paint.Style.STROKE
        strokeWidth = helperDimensions.backgroundWidth
        isAntiAlias = true
        alpha = 175
    }

    private val progressPaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = helperDimensions.progressWidth
        isAntiAlias = true
    }

    fun setProgress(progress: Float) {
        helperDimensions.onProgressSet(progress)
        invalidate()
    }

    fun setProgressColor(@ColorInt color: Int) {
        progressPaint.color = color
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        helperDimensions.onSizeChanged(w, h)
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBackgroundCircle(canvas)
        drawProgressCircle(canvas)
    }

    private fun drawBackgroundCircle(canvas: Canvas?) {
        val centerX = helperDimensions.backgroundCenterX
        val centerY = helperDimensions.backgroundCenterY
        val radius = helperDimensions.progressRadius

        canvas?.drawCircle(centerX, centerY, radius, backgroundPaint)
    }

    private fun drawProgressCircle(canvas: Canvas?) {
        val oval = helperDimensions.progressRect
        val startAngle = helperDimensions.progressStartAngle
        val sweepAngle = helperDimensions.progressSweepAngle

        canvas?.drawArc(
            oval,
            startAngle,
            sweepAngle,
            false,
            progressPaint
        )
    }
}