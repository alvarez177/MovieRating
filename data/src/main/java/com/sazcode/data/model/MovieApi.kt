package com.sazcode.data.model

import com.google.gson.annotations.SerializedName
import com.sazcode.domain.model.Movie

data class MovieApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("poster_path")
    val image: String
)

fun MovieApi.toMovie(): Movie {
    return Movie(
        id,
        title,
        rating,
        image
    )
}
