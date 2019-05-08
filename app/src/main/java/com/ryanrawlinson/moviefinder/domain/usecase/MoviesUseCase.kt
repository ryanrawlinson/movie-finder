package com.ryanrawlinson.moviefinder.domain.usecase

import com.ryanrawlinson.moviefinder.data.remote.MovieRepository
import com.ryanrawlinson.moviefinder.ui.base.Action
import com.ryanrawlinson.moviefinder.ui.base.UseCase
import com.ryanrawlinson.moviefinder.ui.movies.MoviesViewState
import com.ryanrawlinson.moviefinder.util.produceActions
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MovieRepository) : UseCase {

    fun getPopularMovies(): ReceiveChannel<Action<MoviesViewState>> =
        produceActions {
            send(Action { copy(isLoading = true) })
            try {
                val response = repository.getPopularMovies().await()
                if (response.isSuccessful) {
                    response.body()?.let { response ->
                        response.results?.let { movies ->
                            send(Action { copy(isLoading = false, movies = movies, error = null) })
                        }
                    }
                }
            } catch (e: Throwable) {
                send(Action { copy(isLoading = false, error = e) })
            }
        }
}