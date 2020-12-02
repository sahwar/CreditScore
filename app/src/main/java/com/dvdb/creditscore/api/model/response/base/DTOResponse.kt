package com.dvdb.creditscore.api.model.response.base

abstract class DTOResponse(
    var statusCode: Int? = null,
    var message: String? = null,
    var isSuccessful: Boolean? = null
)