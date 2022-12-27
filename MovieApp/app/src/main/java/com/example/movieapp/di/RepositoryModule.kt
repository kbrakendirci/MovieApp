package com.example.movieapp.di

import com.example.movieapp.data.web.repository.MovieListNetworkRepositoryImpl
import com.example.movieapp.domain.repository.MovieListNetworkRepository
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
    abstract fun bindMovieListRepository(movieListNetworkRepositoryImpl: MovieListNetworkRepositoryImpl) : MovieListNetworkRepository
}