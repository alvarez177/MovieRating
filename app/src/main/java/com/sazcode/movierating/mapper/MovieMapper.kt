package com.sazcode.movierating.mapper

import com.sazcode.domain.model.Movie
import com.sazcode.movierating.model.MovieView

fun Movie.toMovieView(): MovieView {
    return MovieView(
        id, title, rating, image
    )
}