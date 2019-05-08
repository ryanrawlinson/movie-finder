package com.ryanrawlinson.moviefinder.ui.movie

import com.ryanrawlinson.moviefinder.ui.base.BaseViewModel
import com.ryanrawlinson.moviefinder.ui.base.ViewStateStore
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val useCase: MovieUseCase) : BaseViewModel() {

    val store = ViewStateStore(MovieViewState())

    fun getMovie() {
        store.dispatchActions(useCase.getMovie())
    }
}