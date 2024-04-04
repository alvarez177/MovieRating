package com.sazcode.data.repository

import com.sazcode.data.MovieService
import com.sazcode.data.model.toMovie
import com.sazcode.domain.abstractrepository.GetMoviesRepository
import com.sazcode.domain.model.Movie
import javax.inject.Inject

class GetMoviesRepositoryImpl @Inject constructor(private val service: MovieService) :
    GetMoviesRepository {
    override suspend fun getMovies(): List<Movie> {
        val bodyResponse = service.getMoviesResponse().body()
        if (bodyResponse != null) {
            return bodyResponse.results.map { it.toMovie() }
        } else {
            throw Exception("Null body from ${GetMoviesRepository::class.simpleName}")
        }
    }

}