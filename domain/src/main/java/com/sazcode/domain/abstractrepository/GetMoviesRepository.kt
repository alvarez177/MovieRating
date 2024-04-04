package com.sazcode.domain.abstractrepository

import com.sazcode.domain.model.Movie

interface GetMoviesRepository {

    suspend fun getMovies(): List<Movie>
}