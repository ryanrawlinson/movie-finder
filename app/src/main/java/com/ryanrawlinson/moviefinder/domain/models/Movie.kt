package com.ryanrawlinson.moviefinder.domain.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("vote_count")
    var voteCount: Int? = null,
    var id: Int? = null,
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Float? = null,
    var title: String? = null,
    var popularity: Float? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    var adult: Boolean? = null,
    var overview: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null
) : Parcelable
