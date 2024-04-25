package com.sazcode.data.model

import com.google.gson.annotations.SerializedName
import com.sazcode.domain.model.Genres

data class GenresApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val genreName: String
) {
    fun toDomain(): Genres {
        return Genres(id, genreName)
    }
}
