package com.dvdb.creditscore.domain.helper

import com.dvdb.creditscore.api.model.response.DTOResponseOverview
import com.dvdb.creditscore.api.repository.RepositoryOverview

class FakeOverviewRepository(
    private val response: DTOResponseOverview
) : RepositoryOverview {
    override suspend fun getOverview(): DTOResponseOverview = response
}