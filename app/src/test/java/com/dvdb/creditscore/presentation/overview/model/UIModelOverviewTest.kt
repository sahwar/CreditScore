package com.dvdb.creditscore.presentation.overview.model

import com.dvdb.creditscore.FakeFactoryTextSpan
import com.dvdb.creditscore.FakeHelperResourceResolver
import org.junit.Assert
import org.junit.Test

class UIModelOverviewTest {

    private val overviewModel = UIModelOverview(
        score = 504,
        maxScore = 700,
        progressCirclePercentage = 0.72f,
        progressCircleColorRes = 1
    )

    @Test
    fun getScoreSummary_resolvesNullString_resolvesNullAppearanceId_resolvesNullColor_returnsNull() {
        verifyGetScoreSummary(
            resolvedString = null,
            resolvedAppearanceId = null,
            resolvedColor = null
        )
    }

    @Test
    fun getScoreSummary_resolvesNullString_resolvesNonNullAppearanceId_resolvesNullColor_returnsNull() {
        verifyGetScoreSummary(
            resolvedString = null,
            resolvedAppearanceId = 1,
            resolvedColor = null
        )
    }

    @Test
    fun getScoreSummary_resolvesNullString_resolvesNullAppearanceId_resolvesNonNullColor_returnsNull() {
        verifyGetScoreSummary(
            resolvedString = null,
            resolvedAppearanceId = null,
            resolvedColor = 1
        )
    }

    @Test
    fun getScoreSummary_resolvesNullString_resolvesNonNullAppearanceId_resolvesNonNullColor_returnsNull() {
        verifyGetScoreSummary(
            resolvedString = null,
            resolvedAppearanceId = 1,
            resolvedColor = 1
        )
    }

    @Test
    fun getScoreSummary_resolvesNonNullString_resolvesNullAppearanceId_resolvesNullColor_returnsSummary() {
        verifyGetScoreSummary(
            resolvedString = "This is a test",
            resolvedAppearanceId = null,
            resolvedColor = null
        )
    }

    @Test
    fun getScoreSummary_resolvesNonNullString_resolvesNonNullAppearanceId_resolvesNullColor_returnsSummary() {
        verifyGetScoreSummary(
            resolvedString = "This is a test",
            resolvedAppearanceId = 1,
            resolvedColor = null
        )
    }

    @Test
    fun getScoreSummary_resolvesNonNullString_resolvesNullAppearanceId_resolvesNonNullColor_returnsSummary() {
        verifyGetScoreSummary(
            resolvedString = "This is a test",
            resolvedAppearanceId = null,
            resolvedColor = 1
        )
    }

    private fun verifyGetScoreSummary(
        resolvedString: String?,
        resolvedAppearanceId: Int?,
        resolvedColor: Int?
    ) {
        val resourceResolver = FakeHelperResourceResolver(
            getStringValue = resolvedString,
            getResourceIdFromAttribute = resolvedAppearanceId,
            getColor = resolvedColor
        )
        val textSpanFactory = FakeFactoryTextSpan()

        val actualSummary = overviewModel.getScoreSummary(textSpanFactory, resourceResolver)

        Assert.assertEquals(resolvedString, actualSummary)
    }
}