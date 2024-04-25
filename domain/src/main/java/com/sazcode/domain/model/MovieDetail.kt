package com.sazcode.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overView: String,
    val image: String,
    val genres: List<Genres>
)
