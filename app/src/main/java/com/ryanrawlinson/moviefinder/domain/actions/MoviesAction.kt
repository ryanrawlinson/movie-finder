package com.ryanrawlinson.moviefinder.domain.actions

sealed class MoviesAction : Action {
    object GetMoviesAction : MoviesAction()
}