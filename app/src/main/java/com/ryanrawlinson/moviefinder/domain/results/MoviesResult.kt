package com.ryanrawlinson.moviefinder.domain.results

import com.ryanrawlinson.moviefinder.domain.Result
import com.ryanrawlinson.moviefinder.domain.models.Movie

sealed class MoviesResult : Result {
    data class Success(val data: List<Movie>) : MoviesResult()
    data class Failure(val error: String) : MoviesResult()
}