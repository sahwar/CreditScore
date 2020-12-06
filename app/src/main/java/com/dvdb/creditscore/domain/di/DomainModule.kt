package com.dvdb.creditscore.domain.di

import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.domain.model.response.EntityResponseOverview
import com.dvdb.creditscore.domain.usecase.UseCaseFactory
import com.dvdb.creditscore.domain.usecase.impl.UseCaseOverviewGet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DomainModule {

    @Singleton
    @Provides
    fun provideUseCaseOverviewGetFactory(overviewRepository: RepositoryOverview): UseCaseFactory<EntityResponseOverview> {
        return UseCaseOverviewGet.Factory(overviewRepository)
    }
}