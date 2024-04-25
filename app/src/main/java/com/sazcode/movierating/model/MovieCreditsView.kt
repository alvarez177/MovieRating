package com.sazcode.movierating.model

data class MovieCreditsView(
    val id: Int,
    val name: String,
    val characterName: String,
    val image: String?,
    val rating: Float
)