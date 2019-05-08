package com.ryanrawlinson.moviefinder.util

class ImageUtils {

    companion object {
        fun getImageUrl(imagePath: String) = "https://image.tmdb.org/t/p/w185$imagePath"
    }
}