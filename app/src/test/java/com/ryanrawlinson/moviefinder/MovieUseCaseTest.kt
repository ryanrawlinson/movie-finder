package com.ryanrawlinson.moviefinder

import com.ryanrawlinson.moviefinder.data.remote.MovieRepository
import com.ryanrawlinson.moviefinder.domain.api.MovieService
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.domain.usecase.MovieUseCase
import com.ryanrawlinson.moviefinder.ui.movie.MovieViewState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MovieUseCaseTest {

    val movieService: MovieService = mockk()
    val repository = MovieRepository(movieService)
    val useCase = MovieUseCase(repository)

    @Test
    fun getMovie() {
        val MOVIE_1 = Movie()
        coEvery { repository.getMovie() } returns movieService.getMovieDetails(550)

        val initialState = MovieViewState()
        val action = runBlocking {
            useCase.getMovie(initialState)
        }

        val finalState = action(initialState)
        assert(finalState.movie.id != null)
//                MOVIE_1.copy(
//            voteCount = 10,
//            title = "New Test Movie",
//            originalLanguage = "English"
//        )
    }
}
