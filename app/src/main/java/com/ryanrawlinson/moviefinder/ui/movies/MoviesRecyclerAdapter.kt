package com.ryanrawlinson.moviefinder.ui.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryanrawlinson.moviefinder.R
import com.ryanrawlinson.moviefinder.domain.models.Movie
import com.ryanrawlinson.moviefinder.util.ImageUtils
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MoviesRecyclerAdapter(private val listener: (Movie) -> Unit) :
    ListAdapter<Movie, MoviesRecyclerAdapter.ViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) {
            itemView.apply {
                tvMovieTitle.text = movie.title
                tvMovieDescription.text = movie.overview
                tvReleaseDate.text = "Release Date: ${movie.releaseDate}"

                movie.posterPath?.run {
                    Log.d(MoviesRecyclerAdapter::class.java.simpleName, this)
                    Glide
                        .with(context)
                        .load(ImageUtils.getImageUrl(this))
                        .into(ivMovieImage)
                }

                setOnClickListener {
                    listener.invoke(movie)
                }
            }
        }
    }
}

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}