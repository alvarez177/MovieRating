package com.sazcode.data.model

import com.google.gson.annotations.SerializedName
import com.sazcode.domain.model.MovieCredit

data class MovieCreditsResponseApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val credits: List<MovieCreditResponseApi>
) {

}
