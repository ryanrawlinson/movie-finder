package com.ryanrawlinson.moviefinder.ui.movies

import com.ryanrawlinson.moviefinder.domain.usecase.MoviesUseCase
import com.ryanrawlinson.moviefinder.ui.base.BaseViewModel
import com.ryanrawlinson.moviefinder.ui.base.ViewStateStore
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val useCase: MoviesUseCase) : BaseViewModel() {

    val store = ViewStateStore(MoviesViewState())

    fun getMovies() {
        store.dispatchActions(useCase.getPopularMovies())
    }
}