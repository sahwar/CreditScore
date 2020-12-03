package com.dvdb.creditscore.api.di

import com.dvdb.creditscore.api.network.service.ApiService
import com.dvdb.creditscore.api.network.service.impl.ApiServiceImpl
import com.dvdb.creditscore.api.network.service.overview.ApiServiceOverview
import com.dvdb.creditscore.api.repository.RepositoryOverview
import com.dvdb.creditscore.api.repository.impl.RepositoryOverviewImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideMoshiConvertFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://android-interview.s3.eu-west-2.amazonaws.com/")
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiOverviewService(retrofit: Retrofit): ApiServiceOverview {
        return retrofit.create(ApiServiceOverview::class.java)
    }

    @Singleton
    @Provides
    fun provideApiService(apiServiceOverview: ApiServiceOverview): ApiService {
        return ApiServiceImpl(apiServiceOverview)
    }

    @Singleton
    @Provides
    fun provideOverviewRepository(apiService: ApiService): RepositoryOverview {
        return RepositoryOverviewImpl(apiService)
    }
}