package com.sazcode.domain.model

data class MovieCredit(
    val id: Int,
    val name: String,
    val characterName: String,
    val image: String?,
    val rating: Float
)