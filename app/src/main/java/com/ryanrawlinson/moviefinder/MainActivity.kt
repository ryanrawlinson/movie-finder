package com.ryanrawlinson.moviefinder

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.ryanrawlinson.moviefinder.di.ViewModelFactory
import com.ryanrawlinson.moviefinder.ui.movie.MovieViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy(mode = LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, viewModelFactory)[MovieViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnGetMovie.setOnClickListener { viewModel.getMovie() }

//        viewModel.store.observe(this) { state ->
            //            progressBar.isVisible = state.loading
//            tvTitle.text = state.movie.title

//            state.error?.run {
//                Snackbar.make(clParent, this.localizedMessage, Snackbar.LENGTH_SHORT).show()
//            }
//        }
    }
}
