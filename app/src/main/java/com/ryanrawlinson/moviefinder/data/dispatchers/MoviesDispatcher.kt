package com.ryanrawlinson.moviefinder.data.dispatchers

import androidx.lifecycle.liveData
import com.ryanrawlinson.moviefinder.data.remote.MovieRepository
import com.ryanrawlinson.moviefinder.domain.actions.Action
import com.ryanrawlinson.moviefinder.domain.actions.MoviesAction
import com.ryanrawlinson.moviefinder.domain.results.MoviesResult
import javax.inject.Inject

class MoviesDispatcher @Inject constructor(private val repository: MovieRepository) {

    fun dispatchAction(action: Action) = liveData {
        when (action) {
            is MoviesAction.GetMoviesAction -> {
                emit(MoviesResult.Loading)
                emit(getPopularMovies())
            }
        }
    }

    private suspend fun getPopularMovies(): MoviesResult {
        try {
            val response = repository.getPopularMovies().await()
            if (response.isSuccessful) {
                response.body()?.let { responseBody ->
                    responseBody.results?.run {
                        return MoviesResult.Success(this)
                    }
                }
            }
        } catch (t: Throwable) {
            return MoviesResult.Failure(t.localizedMessage)
        }

        return MoviesResult.Failure("Failure to retrieve movies.")
    }
}