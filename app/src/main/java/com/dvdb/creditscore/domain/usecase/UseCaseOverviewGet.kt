package com.dvdb.creditscore.domain.usecase

import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.model.transformer.response.transform
import com.dvdb.creditscore.domain.usecase.base.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UseCaseOverviewGet private constructor(
    private val repository: RepositoryOverview
) : UseCase<EntityResponseOverview> {

    override suspend fun execute(): EntityResponseOverview = withContext(Dispatchers.IO) {
        repository.getOverview().transform()
    }

    class Factory(
        private val repository: RepositoryOverview
    ) {
        fun create(): UseCaseOverviewGet = UseCaseOverviewGet(repository)
    }
}