package com.ryanrawlinson.moviefinder.ui.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanrawlinson.moviefinder.R
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.list_item_movie.*

class MoviesFragment : BaseFragment() {

    private val viewModel: MoviesViewModel by viewModels { viewModelFactory }

    private val moviesRecyclerAdapter = MoviesRecyclerAdapter(::onListItemClicked)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.moviesState.observe(this) {
            render(it)
        }
    }

    private fun render(state: MoviesViewState) {
        progressBar.isVisible = state.isLoading
        moviesRecyclerAdapter.submitList(state.movies)

        if (state.error != null) {
            Toast.makeText(context, state.error.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        rvMovies.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = moviesRecyclerAdapter
            setHasFixedSize(true)
        }
    }

    private fun onListItemClicked(movie: Movie) {
        val extras = FragmentNavigatorExtras(
            ivMovieImage to "posterImage"
        )

        val bundle = bundleOf("movie" to movie)
        findNavController().navigate(R.id.detailAction, bundle, null, extras)
    }
}
