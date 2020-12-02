package com.dvdb.creditscore.domain.model.transformer.response.base

import com.dvdb.creditscore.api.model.response.base.DTOResponse
import com.dvdb.creditscore.domain.model.response.base.EntityResponse

object TransformerResponse {
    fun transform(dtoResponse: DTOResponse, entityResponse: EntityResponse) {
        entityResponse.statusCode = dtoResponse.statusCode ?: -1
        entityResponse.message = dtoResponse.message ?: String()
        entityResponse.isSuccessful = dtoResponse.isSuccessful ?: false
    }
}