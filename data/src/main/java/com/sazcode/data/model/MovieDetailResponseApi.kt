package com.sazcode.data.model

import com.google.gson.annotations.SerializedName
import com.sazcode.domain.model.MovieDetail

data class MovieDetailResponseApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overView: String,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("genres")
    val genres: List<GenresApi>
) {
    fun toDomain(): MovieDetail {
        return MovieDetail(id, title, overView, image, genres.map { it.toDomain() })
    }
}
