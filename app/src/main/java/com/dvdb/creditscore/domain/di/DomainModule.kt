package com.dvdb.creditscore.domain.di

import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.domain.usecase.UseCaseOverviewGet
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
    fun provideUseCaseOverviewGetFactory(overviewRepository: RepositoryOverview): UseCaseOverviewGet.Factory {
        return UseCaseOverviewGet.Factory(overviewRepository)
    }
}