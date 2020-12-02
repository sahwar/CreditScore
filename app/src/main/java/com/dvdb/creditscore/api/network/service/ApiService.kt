package com.dvdb.creditscore.api.network.service

import com.dvdb.creditscore.api.model.response.DTOResponseOverview

interface ApiService {
    suspend fun getOverview(): DTOResponseOverview
}