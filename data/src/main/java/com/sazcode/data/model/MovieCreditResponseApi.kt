package com.sazcode.data.model

import com.google.gson.annotations.SerializedName
import com.sazcode.domain.model.MovieCredit

data class MovieCreditResponseApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("character")
    val characterName: String,
    @SerializedName("profile_path")
    val image: String,
    @SerializedName("popularity")
    val rating: Float
) {
    fun toDomain(): MovieCredit {
        return MovieCredit(id, name, characterName, image, rating)
    }
}
