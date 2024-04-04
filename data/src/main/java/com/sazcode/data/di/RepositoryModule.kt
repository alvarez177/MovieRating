package com.sazcode.data.di

import com.sazcode.data.repository.GetMoviesRepositoryImpl
import com.sazcode.domain.abstractrepository.GetMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindGetMoviesRepository(getMoviesRepositoryImpl: GetMoviesRepositoryImpl): GetMoviesRepository

}