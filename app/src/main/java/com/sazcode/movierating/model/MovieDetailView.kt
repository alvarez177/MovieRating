package com.sazcode.movierating.model

import com.sazcode.domain.model.Genres
import com.sazcode.domain.model.MovieCredit
import com.sazcode.domain.model.MovieDetail

data class MovieDetailView(
    val id: Int,
    val title: String,
    val overView: String,
    val image: String,
    val genres: List<Genres>,
    val credits: List<MovieCreditsView>
)
