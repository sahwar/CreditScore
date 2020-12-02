package com.dvdb.creditscore.api.network.service.overview

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceOverview {
    @GET("endpoint.json")
    suspend fun getOverview(): Response<DTOResponseOverview>
}