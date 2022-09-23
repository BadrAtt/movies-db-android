package com.elattaoui.badr.moviesdb.data.di

import com.elattaoui.badr.moviesdb.data.repository.MoviesRepository
import com.elattaoui.badr.moviesdb.data.repository.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMoviesRepository(
        moviesRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository
}
