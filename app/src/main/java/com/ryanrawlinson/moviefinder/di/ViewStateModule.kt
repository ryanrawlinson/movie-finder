package com.ryanrawlinson.moviefinder.di

import com.ryanrawlinson.moviefinder.ui.base.ViewState
import com.ryanrawlinson.moviefinder.ui.base.ViewStateStore
import com.ryanrawlinson.moviefinder.ui.movie.MovieViewState
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewStateModule {

    @Provides
    @Singleton
    fun provideViewStateStore(viewState: ViewState) = ViewStateStore(viewState)
}