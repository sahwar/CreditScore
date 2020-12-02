package com.dvdb.creditscore.domain.model.response.base

abstract class EntityResponse(
    var statusCode: Int = 0,
    var message: String = String(),
    var isSuccessful: Boolean = false
)