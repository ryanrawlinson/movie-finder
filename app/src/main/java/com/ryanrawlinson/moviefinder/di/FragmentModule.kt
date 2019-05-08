package com.ryanrawlinson.moviefinder.di

import com.ryanrawlinson.moviefinder.ui.movie.MovieDetailFragment
import com.ryanrawlinson.moviefinder.ui.movies.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun bindMovieDetailFragment(): MovieDetailFragment
}