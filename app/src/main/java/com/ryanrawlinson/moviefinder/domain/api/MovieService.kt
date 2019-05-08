package com.ryanrawlinson.moviefinder.domain.api

import com.ryanrawlinson.moviefinder.domain.MoviesResponse
import com.ryanrawlinson.moviefinder.domain.models.Movie
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/{movieId}")
    fun getMovieDetails(@Path("movieId") movieId: Int): Deferred<Response<Movie>>

    @GET("movie/popular")
    fun getPopularMovies(): Deferred<Response<MoviesResponse>>
}