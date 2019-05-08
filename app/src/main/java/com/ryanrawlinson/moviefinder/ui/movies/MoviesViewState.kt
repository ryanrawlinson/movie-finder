package com.ryanrawlinson.moviefinder.ui.movies

import com.google.gson.annotations.SerializedName
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.ui.base.ViewState

data class MoviesViewState(
    val isLoading: Boolean = false,
    @SerializedName("results")
    val movies: List<Movie> = emptyList(),
    val error: Throwable? = null
) : ViewState