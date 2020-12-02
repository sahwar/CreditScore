package com.dvdb.creditscore.domain.model

import org.junit.Assert
import org.junit.Test

class EntityOverviewScoreBandTypeTest {

    private val typeValues = EntityOverviewScoreBandType.values().map { it.value }

    @Test
    fun fromInt_unknownType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.UNKNOWN,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[0])
        )
    }

    @Test
    fun fromInt_veryPoorType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.VERY_POOR,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[1])
        )
    }

    @Test
    fun fromInt_poorType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.POOR,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[2])
        )
    }

    @Test
    fun fromInt_fairType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.FAIR,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[3])
        )
    }

    @Test
    fun fromInt_goodType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.GOOD,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[4])
        )
    }

    @Test
    fun fromInt_veryGoodType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.VERY_GOOD,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[5])
        )
    }

    @Test
    fun fromInt_excellentType() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.EXCELLENT,
            actualType = EntityOverviewScoreBandType.fromInt(typeValues[6])
        )
    }

    @Test
    fun fromInt_fallback() {
        assertEquals(
            expectedType = EntityOverviewScoreBandType.UNKNOWN,
            actualType = EntityOverviewScoreBandType.fromInt(Int.MIN_VALUE)
        )
    }

    @Test
    fun fromInt_allTypesCovered() {
        Assert.assertEquals(
            "Update test to cover all overview score band types",
            7,
            typeValues.size
        )
    }

    private fun assertEquals(
        expectedType: EntityOverviewScoreBandType,
        actualType: EntityOverviewScoreBandType
    ) {
        Assert.assertEquals(expectedType, actualType)
    }
}