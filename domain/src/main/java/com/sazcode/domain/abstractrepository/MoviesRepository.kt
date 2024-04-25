package com.sazcode.domain.abstractrepository

import com.sazcode.domain.model.Movie
import com.sazcode.domain.model.MovieCredit
import com.sazcode.domain.model.MovieDetail

interface MoviesRepository {

    suspend fun getMovies(): List<Movie>

    suspend fun getDetailMovie(movieId: String): MovieDetail

    suspend fun getCredits(movieId: String): List<MovieCredit>
}