package com.sazcode.data

import com.sazcode.data.model.MovieCreditsResponseApi
import com.sazcode.data.model.MovieDetailResponseApi
import com.sazcode.data.model.MovieResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("discover/movie")
    suspend fun getMoviesResponse(): Response<MovieResponseApi>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovieResponse(@Path("movie_id") movieId: String):Response<MovieDetailResponseApi>

    @GET("movie/{movie_id}/credits")
    suspend fun getCreditsResponse(@Path("movie_id") movieId: String): Response<MovieCreditsResponseApi>
}