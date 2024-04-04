package com.sazcode.data

import com.sazcode.data.model.MovieResponseApi
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("discover/movie")
    suspend fun getMoviesResponse(): Response<MovieResponseApi>
}