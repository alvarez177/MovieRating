package com.sazcode.movierating.mapper

import com.sazcode.domain.model.Movie
import com.sazcode.domain.model.MovieCredit
import com.sazcode.domain.model.MovieDetail
import com.sazcode.movierating.model.MovieCreditsView
import com.sazcode.movierating.model.MovieDetailView
import com.sazcode.movierating.model.MovieView

fun Movie.toMovieView(): MovieView {
    return MovieView(
        id, title, rating, image
    )
}

fun MovieDetail.toMovieDetailView(credits: List<MovieCreditsView> = emptyList()): MovieDetailView {
    return MovieDetailView(id, title, overView, image, genres, credits)
}

fun MovieCredit.toMovieCreditsView(): MovieCreditsView {
    return MovieCreditsView(id, name, characterName, image, rating)
}