package com.dvdb.creditscore.api.network.service.impl

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.model.response.base.DTOResponse
import com.dvdb.creditscore.api.network.service.ApiService
import com.dvdb.creditscore.api.network.service.overview.ApiServiceOverview
import retrofit2.Response

class ApiServiceImpl(
    private val overviewService: ApiServiceOverview
) : ApiService {

    override suspend fun getOverview(): DTOResponseOverview {
        val response = overviewService.getOverview()
        return (response.body() ?: DTOResponseOverview()).applyBaseProperties(response)
    }

    private inline fun <reified T : DTOResponse> DTOResponse.applyBaseProperties(response: Response<*>): T =
        apply {
            statusCode = response.code()
            message = response.message()
            isSuccessful = response.isSuccessful
        } as T
}