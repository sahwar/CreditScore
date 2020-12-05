package com.dvdb.creditscore.presentation.overview.model

import org.junit.Assert
import org.junit.Test

class UIModelOverviewScoreBandTypeTest {
    private val typeValues = UIModelOverviewScoreBandType.values().map { it.value }

    @Test
    fun fromInt_unknownType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.UNKNOWN,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[0])
        )
    }

    @Test
    fun fromInt_veryPoorType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.VERY_POOR,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[1])
        )
    }

    @Test
    fun fromInt_poorType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.POOR,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[2])
        )
    }

    @Test
    fun fromInt_fairType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.FAIR,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[3])
        )
    }

    @Test
    fun fromInt_goodType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.GOOD,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[4])
        )
    }

    @Test
    fun fromInt_veryGoodType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.VERY_GOOD,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[5])
        )
    }

    @Test
    fun fromInt_excellentType() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.EXCELLENT,
            actualType = UIModelOverviewScoreBandType.fromInt(typeValues[6])
        )
    }

    @Test
    fun fromInt_fallback() {
        assertEquals(
            expectedType = UIModelOverviewScoreBandType.UNKNOWN,
            actualType = UIModelOverviewScoreBandType.fromInt(Int.MIN_VALUE)
        )
    }

    @Test
    fun fromInt_allTypesCovered() {
        val requiredUnitTestCount = typeValues.size
        Assert.assertEquals(
            "Update test to cover all $requiredUnitTestCount overview score band types",
            7,
            requiredUnitTestCount
        )
    }

    private fun assertEquals(
        expectedType: UIModelOverviewScoreBandType,
        actualType: UIModelOverviewScoreBandType
    ) {
        Assert.assertEquals(expectedType, actualType)
    }
}