package com.ryanrawlinson.moviefinder.ui.movie

import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.ui.base.ViewState

data class MovieViewState(
    val loading: Boolean = false,
    val movie: Movie = Movie(),
    val error: Throwable? = null
) : ViewState