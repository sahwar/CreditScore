package com.dvdb.creditscore.domain.model.transformer.response.base

import com.dvdb.creditscore.api.model.response.base.DTOResponse
import com.dvdb.creditscore.domain.helper.HelperEntityDefaults
import com.dvdb.creditscore.domain.model.response.base.EntityResponse
import org.junit.Assert
import org.junit.Test

class TransformerResponseTest {

    @Test
    fun transform_nonNullValues() {
        // Expected values
        val expectedStatusCode = 200
        val expectedMessage = "OK"
        val expectedIsSuccessful = true

        // Input response
        val dtoResponse = object : DTOResponse(
            statusCode = expectedStatusCode,
            message = expectedMessage,
            isSuccessful = expectedIsSuccessful
        ) {}

        // Output response transformed from input response
        val actualEntityResponse = object : EntityResponse() {}
        TransformerResponse.transform(dtoResponse, actualEntityResponse)

        actualEntityResponse.assertValues(
            expectedStatusCode,
            expectedMessage,
            expectedIsSuccessful
        )
    }

    @Test
    fun transform_nullValues_assignDefaults() {
        // Expected default values
        val expectedStatusCode = HelperEntityDefaults.INTEGER
        val expectedMessage = HelperEntityDefaults.STRING
        val expectedIsSuccessful = HelperEntityDefaults.BOOLEAN

        // Input response
        val dtoResponse = object : DTOResponse() {}

        // Output response transformed from input response
        val actualEntityResponse = object : EntityResponse() {}
        TransformerResponse.transform(dtoResponse, actualEntityResponse)

        actualEntityResponse.assertValues(
            expectedStatusCode,
            expectedMessage,
            expectedIsSuccessful
        )
    }

    private fun EntityResponse.assertValues(
        expectedStatusCode: Int,
        expectedMessage: String,
        expectedIsSuccessful: Boolean
    ) {
        Assert.assertEquals(expectedStatusCode, statusCode)
        Assert.assertEquals(expectedMessage, message)
        Assert.assertEquals(expectedIsSuccessful, isSuccessful)
    }
}