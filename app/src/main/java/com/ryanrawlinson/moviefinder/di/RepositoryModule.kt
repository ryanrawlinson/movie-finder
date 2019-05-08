package com.ryanrawlinson.moviefinder.di

import com.ryanrawlinson.moviefinder.data.remote.MovieRepository
import com.ryanrawlinson.moviefinder.domain.api.MovieService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieService: MovieService) = MovieRepository(movieService)
}