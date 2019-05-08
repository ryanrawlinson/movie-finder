package com.ryanrawlinson.moviefinder.ui.movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target

import com.ryanrawlinson.moviefinder.R
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.ui.base.BaseFragment
import com.ryanrawlinson.moviefinder.util.ImageUtils
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = arguments?.getParcelable<Movie>("movie")

        movie?.run {
            tvMovieTitle.text = this.title
            tvMovieDescription.text = this.overview

            context?.let {
                Glide
                    .with(it)
                    .load(movie.backdropPath?.let { it1 ->
                        ImageUtils.getImageUrl(it1)
                    })
                    .centerCrop()
                    .override(Target.SIZE_ORIGINAL)
                    .into(ivMovieBackdrop)

                Glide
                    .with(it)
                    .load(movie.posterPath?.let { it1 ->
                        ImageUtils.getImageUrl(it1)
                    })
                    .into(ivMoviePoster)
            }
        }
    }
}
