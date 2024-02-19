package com.example.periodictableapplication.di

import com.example.periodictableapplication.data.PeriodicElementsRepositoryImpl
import com.example.periodictableapplication.data.api.Service
import com.example.periodictableapplication.domain.PeriodicElementsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): Service {
        return Service.createApiService()
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: Service
    ): PeriodicElementsRepository {
        return PeriodicElementsRepositoryImpl(api)
    }
}