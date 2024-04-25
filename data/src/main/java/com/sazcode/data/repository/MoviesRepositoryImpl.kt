package com.sazcode.data.repository

import com.sazcode.data.MovieService
import com.sazcode.data.model.MovieDetailResponseApi
import com.sazcode.data.model.toMovie
import com.sazcode.domain.abstractrepository.MoviesRepository
import com.sazcode.domain.model.Movie
import com.sazcode.domain.model.MovieCredit
import com.sazcode.domain.model.MovieDetail
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val service: MovieService) :
    MoviesRepository {
    override suspend fun getMovies(): List<Movie> {
        val bodyResponse = service.getMoviesResponse().body()
        if (bodyResponse != null) {
            return bodyResponse.results.map { it.toMovie() }
        } else {
            throw Exception("Null body from ${MoviesRepository::class.simpleName}")
        }
    }

    override suspend fun getDetailMovie(movieId: String): MovieDetail {
        val bodyResponse: MovieDetailResponseApi? = service.getDetailMovieResponse(movieId).body()
        if (bodyResponse != null) {
            return bodyResponse.toDomain()
        } else {
            throw Exception("Null body from ${MoviesRepository::class.simpleName}")
        }
    }

    override suspend fun getCredits(movieId: String): List<MovieCredit> {
        val bodyResponse = service.getCreditsResponse(movieId).body()
        if (bodyResponse != null) {
            return bodyResponse.credits.map { it.toDomain() }
        } else {
            throw Exception("Null body from ${MoviesRepository::class.simpleName}")
        }
    }
}