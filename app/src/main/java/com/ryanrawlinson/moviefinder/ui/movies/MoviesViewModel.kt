package com.ryanrawlinson.moviefinder.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ryanrawlinson.moviefinder.data.dispatchers.MoviesDispatcher
import com.ryanrawlinson.moviefinder.domain.actions.MoviesAction
import com.ryanrawlinson.moviefinder.domain.results.MoviesResult
import com.ryanrawlinson.moviefinder.ui.base.BaseViewModel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(dispatcher: MoviesDispatcher) : BaseViewModel() {

    private val viewState = MoviesViewState()

    val moviesState: LiveData<MoviesViewState> =
        Transformations.map(dispatcher.dispatchAction(MoviesAction.GetMoviesAction)) {
            when (it) {
                is MoviesResult.Loading -> viewState.copy(isLoading = true)
                is MoviesResult.Success -> viewState.copy(isLoading = false, movies = it.data, error = null)
                is MoviesResult.Failure -> viewState.copy(isLoading = false, error = null)
            }
        }
}