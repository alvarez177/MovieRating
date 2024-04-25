package com.sazcode.domain.usecase

import com.sazcode.domain.abstractrepository.MoviesRepository
import com.sazcode.domain.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke(movieId: String): MovieDetail {
        return withContext(Dispatchers.IO) {
            repository.getDetailMovie(movieId)
        }
    }
}