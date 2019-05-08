package com.ryanrawlinson.moviefinder.ui.movie

import com.ryanrawlinson.moviefinder.data.remote.MovieRepository
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.ui.base.Action
import com.ryanrawlinson.moviefinder.ui.base.UseCase
import com.ryanrawlinson.moviefinder.util.produceActions
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) : UseCase {
    fun getMovie(): ReceiveChannel<Action<MovieViewState>> =
        produceActions {
            send(Action { copy(loading = true, error = null) })
            try {
                val response = movieRepository.getMovie().await()
                if (response.isSuccessful) {
                    response.body()?.let {
                        send(Action { copy(loading = false, movie = it, error = null) })
                    }
                } else {
                    send(Action { copy(loading = false, movie = Movie(), error = Throwable(response.code().toString())) })
                }
            } catch (e: Throwable) {
                send(Action { copy(loading = false, error = e) })
            }
        }
}