package com.dvdb.creditscore.domain.usecase.impl

import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.model.transformer.response.transform
import com.dvdb.creditscore.domain.usecase.UseCase
import com.dvdb.creditscore.domain.usecase.UseCaseFactory
import com.dvdb.creditscore.domain.usecase.impl.base.UseCaseBase

class UseCaseOverviewGet private constructor(
    private val repository: RepositoryOverview
) : UseCaseBase<EntityResponseOverview>() {

    override suspend fun doWork(): EntityResponseOverview = repository.getOverview().transform()

    class Factory(
        private val repository: RepositoryOverview
    ) : UseCaseFactory<EntityResponseOverview> {
        override fun create(): UseCase<EntityResponseOverview> = UseCaseOverviewGet(repository)
    }
}