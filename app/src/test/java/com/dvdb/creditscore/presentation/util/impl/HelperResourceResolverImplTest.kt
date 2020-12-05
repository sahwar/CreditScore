package com.dvdb.creditscore.presentation.util.impl

import org.junit.Assert
import org.junit.Test

class HelperResourceResolverImplTest {

    private val helperResourceResolver = HelperResourceResolverImpl(null)

    @Test
    fun getString_nullContext_returnNull() {
        val expectedString = null

        val actualString = helperResourceResolver.getString(0)

        Assert.assertEquals(expectedString, actualString)
    }

    @Test
    fun getColor_nullContext_returnNull() {
        val expectedColor = null

        val actualColor = helperResourceResolver.getColor(0)

        Assert.assertEquals(expectedColor, actualColor)
    }

    @Test
    fun getDimension_nullContext_returnNull() {
        val expectedDimension = null

        val actualDimension = helperResourceResolver.getDimension(0)

        Assert.assertEquals(expectedDimension, actualDimension)
    }

    @Test
    fun getDimensionPixelSize_nullContext_returnNull() {
        val expectedDimension = null

        val actualDimension = helperResourceResolver.getDimensionPixelSize(0)

        Assert.assertEquals(expectedDimension, actualDimension)
    }

    @Test
    fun getResourceIdFromAttribute_nullContext_returnNull() {
        val expectedResourceId = null

        val actualResourceId = helperResourceResolver.getResourceIdFromAttribute(0)

        Assert.assertEquals(expectedResourceId, actualResourceId)
    }
}