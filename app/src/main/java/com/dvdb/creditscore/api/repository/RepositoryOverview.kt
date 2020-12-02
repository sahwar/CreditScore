package com.dvdb.creditscore.api.repository

import com.dvdb.creditscore.api.model.response.DTOResponseOverview

interface RepositoryOverview {
    suspend fun getOverview(): DTOResponseOverview
}