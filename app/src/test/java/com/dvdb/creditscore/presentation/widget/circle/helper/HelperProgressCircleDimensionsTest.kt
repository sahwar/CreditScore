package com.dvdb.creditscore.presentation.widget.circle.helper

import com.dvdb.creditscore.domain.helper.FakeHelperResourceResolver
import org.junit.Assert
import org.junit.Test

class HelperProgressCircleDimensionsTest {

    private val defaultResourceResolver = FakeHelperResourceResolver(
        getDimension = 1f,
        getDimensionPixelSize = 1
    )

    private val defaultHelper = HelperProgressCircleDimensions(defaultResourceResolver)

    @Test
    fun onSizeChanged_backgroundWidth_noChange() {
        val expectedBackgroundWidth = defaultHelper.backgroundWidth

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualBackgroundWidth = defaultHelper.backgroundWidth

        Assert.assertEquals(expectedBackgroundWidth, actualBackgroundWidth)
    }

    @Test
    fun onSizeChanged_backgroundCenterX_changed() {
        val width = 10
        val expectedCenterX = width.toFloat() / 2

        defaultHelper.onSizeChanged(width = width, height = 10)

        val actualCenterX = defaultHelper.backgroundCenterX

        Assert.assertEquals(expectedCenterX, actualCenterX)
    }

    @Test
    fun onSizeChanged_backgroundCenterY_changed() {
        val height = 10
        val expectedCenterY = height.toFloat() / 2

        defaultHelper.onSizeChanged(width = 10, height = height)

        val actualCenterY = defaultHelper.backgroundCenterY

        Assert.assertEquals(expectedCenterY, actualCenterY)
    }

    @Test
    fun onSizeChanged_progressWidth_noChange() {
        val expectedProgress = defaultHelper.progressWidth

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualProgress = defaultHelper.progressWidth

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onSizeChanged_progressMargin_noChange() {
        val expectedProgress = defaultHelper.progressMargin

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualProgress = defaultHelper.progressMargin

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onSizeChanged_progress_noChange() {
        val expectedProgress = defaultHelper.progress

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualProgress = defaultHelper.progress

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onSizeChanged_progressStartAngle_noChange() {
        val expectedProgressStartAngle = defaultHelper.progressStartAngle

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualProgressStartAngle = defaultHelper.progressStartAngle

        Assert.assertEquals(expectedProgressStartAngle, actualProgressStartAngle)
    }

    @Test
    fun onSizeChanged_progressSweepAngle_noChange() {
        val expectedProgressSweepAngle = defaultHelper.progressSweepAngle

        defaultHelper.onSizeChanged(width = 10, height = 10)

        val actualProgressSweepAngle = defaultHelper.progressSweepAngle

        Assert.assertEquals(expectedProgressSweepAngle, actualProgressSweepAngle)
    }

    @Test
    fun onSizeChanged_progressRadius_changed() {
        val width = 10
        val expectedProgressRadius = (width.toFloat() / 2) - defaultHelper.progressWidth

        defaultHelper.onSizeChanged(width = width, height = 10)

        val actualProgressRadius = defaultHelper.progressRadius

        Assert.assertEquals(expectedProgressRadius, actualProgressRadius)
    }

    @Test
    fun onProgressSet_backgroundWidth_noChange() {
        val expectedBackgroundWidth = defaultHelper.backgroundWidth

        defaultHelper.onProgressSet(0.5f)

        val actualBackgroundWidth = defaultHelper.backgroundWidth

        Assert.assertEquals(expectedBackgroundWidth, actualBackgroundWidth)
    }

    @Test
    fun onProgressSet_backgroundCenterX_noChange() {
        val expectedCenterX = defaultHelper.backgroundCenterX

        defaultHelper.onProgressSet(0.5f)

        val actualCenterX = defaultHelper.backgroundCenterX

        Assert.assertEquals(expectedCenterX, actualCenterX)
    }

    @Test
    fun onProgressSet_backgroundCenterY_noChange() {
        val expectedCenterY = defaultHelper.backgroundCenterY

        defaultHelper.onProgressSet(0.5f)

        val actualCenterY = defaultHelper.backgroundCenterY

        Assert.assertEquals(expectedCenterY, actualCenterY)
    }

    @Test
    fun onProgressSet_progressWidth_noChange() {
        val expectedProgress = defaultHelper.progressWidth

        defaultHelper.onProgressSet(0.5f)

        val actualProgress = defaultHelper.progressWidth

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onProgressSet_progressMargin_noChange() {
        val expectedProgress = defaultHelper.progressMargin

        defaultHelper.onProgressSet(0.5f)

        val actualProgress = defaultHelper.progressMargin

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onProgressSet_progress_changed_withinBounds() {
        val expectedProgress = 0.5f

        defaultHelper.onProgressSet(expectedProgress)

        val actualProgress = defaultHelper.progress

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onProgressSet_progress_changed_belowLowerBounds_coercedToMin() {
        val expectedProgress = 0f

        defaultHelper.onProgressSet(-10f)

        val actualProgress = defaultHelper.progress

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onProgressSet_progress_changed_beyondUpperBounds_coercedToMax() {
        val expectedProgress = 1f

        defaultHelper.onProgressSet(10f)

        val actualProgress = defaultHelper.progress

        Assert.assertEquals(expectedProgress, actualProgress)
    }

    @Test
    fun onProgressSet_progressStartAngle_noChange() {
        val expectedProgressStartAngle = defaultHelper.progressStartAngle

        defaultHelper.onProgressSet(0.5f)

        val actualProgressStartAngle = defaultHelper.progressStartAngle

        Assert.assertEquals(expectedProgressStartAngle, actualProgressStartAngle)
    }

    @Test
    fun onProgressSet_progressSweepAngle_changed() {
        val progress = 0.5f
        val expectedProgressSweepAngle = 360f * progress

        defaultHelper.onProgressSet(progress)

        val actualProgressSweepAngle = defaultHelper.progressSweepAngle

        Assert.assertEquals(expectedProgressSweepAngle, actualProgressSweepAngle)
    }

    @Test
    fun onProgressSet_progressRadius_noChange() {
        val expectedProgressRadius = defaultHelper.progressRadius

        defaultHelper.onProgressSet(0.5f)

        val actualProgressRadius = defaultHelper.progressRadius

        Assert.assertEquals(expectedProgressRadius, actualProgressRadius)
    }

    @Test
    fun helperResourceResolver_returnNullValue_fallback_backgroundWidth() {
        val expectedBackgroundWidth = 0f

        val resourceResolver = FakeHelperResourceResolver()
        val helper = HelperProgressCircleDimensions(resourceResolver)

        val actualBackgroundWidth = helper.backgroundWidth

        Assert.assertEquals(expectedBackgroundWidth, actualBackgroundWidth)
    }

    @Test
    fun helperResourceResolver_returnNullValue_fallback_progressWidth() {
        val expectedProgressWidth = 0f

        val resourceResolver = FakeHelperResourceResolver()
        val helper = HelperProgressCircleDimensions(resourceResolver)

        val actualProgressWidth = helper.progressWidth

        Assert.assertEquals(expectedProgressWidth, actualProgressWidth)
    }

    @Test
    fun helperResourceResolver_returnNullValue_fallback_progressMargin() {
        val expectedProgressMargin = 0

        val resourceResolver = FakeHelperResourceResolver()
        val helper = HelperProgressCircleDimensions(resourceResolver)

        val actualProgressMargin = helper.progressMargin

        Assert.assertEquals(expectedProgressMargin, actualProgressMargin)
    }
}