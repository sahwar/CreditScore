package com.dvdb.creditscore.presentation.overview.model

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorRes
import com.dvdb.creditscore.R
import com.dvdb.creditscore.presentation.util.FactoryTextSpan
import com.dvdb.creditscore.presentation.util.HelperResourceResolver

data class UIModelOverview(
    private val score: Int,
    private val maxScore: Int,
    val progressCirclePercentage: Float,
    @ColorRes val progressCircleColorRes: Int
) {
    fun getScoreSummary(
        textSpanFactory: FactoryTextSpan,
        resourceResolver: HelperResourceResolver
    ): CharSequence? {
        val scoreSummary = resourceResolver.getString(
            R.string.overview_credit_score_summary,
            score,
            maxScore
        ) ?: return null

        val mainAppearanceId =
            resourceResolver.getResourceIdFromAttribute(R.attr.textAppearanceBody2)
                ?: return scoreSummary

        val scoreValueAppearanceId =
            resourceResolver.getResourceIdFromAttribute(R.attr.textAppearanceHeadline3)
                ?: return scoreSummary

        val scoreValueTextColor =
            resourceResolver.getColor(progressCircleColorRes) ?: return scoreSummary

        return SpannableString(scoreSummary).apply {
            setMainAppearanceSpan(
                textSpanFactory = textSpanFactory,
                source = scoreSummary,
                appearanceId = mainAppearanceId
            )
            setScoreValueAppearanceSpan(
                textSpanFactory = textSpanFactory,
                source = scoreSummary,
                appearanceId = scoreValueAppearanceId,
                textColor = scoreValueTextColor
            )
        }
    }

    private fun SpannableString.setMainAppearanceSpan(
        textSpanFactory: FactoryTextSpan,
        source: String,
        appearanceId: Int
    ) {
        textSpanFactory.createTextAppearanceSpan(appearanceId)?.let { span ->
            setSpan(
                span,
                0,
                source.length,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

    private fun SpannableString.setScoreValueAppearanceSpan(
        textSpanFactory: FactoryTextSpan,
        source: String,
        appearanceId: Int,
        textColor: Int
    ) {
        val startIndex = source.indexOf(score.toString()).takeIf { it != -1 } ?: return
        val endIndex = startIndex + score.toString().length

        textSpanFactory.createTextAppearanceSpan(appearanceId)?.let { span ->
            setSpan(
                span,
                startIndex,
                endIndex,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        setSpan(
            ForegroundColorSpan(textColor),
            startIndex,
            endIndex,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
}