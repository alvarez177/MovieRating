package com.sazcode.domain.usecase

import com.sazcode.domain.abstractrepository.GetMoviesRepository
import com.sazcode.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: GetMoviesRepository) {

    suspend fun invoke(): List<Movie> {
        return withContext(Dispatchers.IO) {
            repository.getMovies()
        }
    }
}