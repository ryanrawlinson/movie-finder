package com.ryanrawlinson.moviefinder.data.remote

import com.ryanrawlinson.moviefinder.domain.api.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {
    fun getMovie() = movieService.getMovieDetails(550)

    fun getPopularMovies() = movieService.getPopularMovies()
}