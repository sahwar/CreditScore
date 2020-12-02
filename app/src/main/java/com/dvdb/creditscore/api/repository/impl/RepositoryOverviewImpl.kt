package com.dvdb.creditscore.api.repository.impl

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.network.service.ApiService
import com.dvdb.creditscore.api.repository.RepositoryOverview

class RepositoryOverviewImpl(
    private val apiService: ApiService
) : RepositoryOverview {

    override suspend fun getOverview(): DTOResponseOverview {
        return apiService.getOverview()
    }
}