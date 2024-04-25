package com.sazcode.data.di

import com.sazcode.data.repository.MoviesRepositoryImpl
import com.sazcode.domain.abstractrepository.MoviesRepository
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
    abstract fun bindGetMoviesRepository(getMoviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

}