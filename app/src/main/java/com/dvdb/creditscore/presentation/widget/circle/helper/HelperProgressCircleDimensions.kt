package com.dvdb.creditscore.presentation.widget.circle.helper

import android.graphics.RectF
import com.dvdb.creditscore.R
import com.dvdb.creditscore.presentation.util.HelperResourceResolver

class HelperProgressCircleDimensions(
    resourceResolver: HelperResourceResolver
) {
    val backgroundWidth: Float = resourceResolver.getDimension(R.dimen.dimen_1) ?: 0f
    var backgroundCenterX: Float = 0f
        private set
    var backgroundCenterY: Float = 0f
        private set

    val progressWidth: Float = resourceResolver.getDimension(R.dimen.space_extra_small) ?: 0f
    val progressMargin: Int = resourceResolver.getDimensionPixelSize(R.dimen.space_small) ?: 0
    var progress: Float = 0f

    val progressRect = RectF()
    val progressStartAngle: Float = 270f
    val progressSweepAngle: Float
        get() = 360f * progress

    var progressRadius = 0f
        private set

    fun onSizeChanged(width: Int, height: Int) {
        val centerX = width.toFloat() / 2
        val centerY = height.toFloat() / 2

        backgroundCenterX = centerX
        backgroundCenterY = centerY

        progressRadius = (width.toFloat() / 2) - progressWidth

        val reducedRadius = progressRadius - progressMargin
        progressRect.set(
            centerX - reducedRadius,
            centerY - reducedRadius,
            centerX + reducedRadius,
            centerY + reducedRadius
        )
    }

    fun onProgressSet(progress: Float) {
        this.progress = progress.coerceIn(0f, 1f)
    }
}