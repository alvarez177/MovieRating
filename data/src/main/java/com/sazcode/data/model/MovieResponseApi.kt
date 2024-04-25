package com.sazcode.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseApi(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieApi>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)