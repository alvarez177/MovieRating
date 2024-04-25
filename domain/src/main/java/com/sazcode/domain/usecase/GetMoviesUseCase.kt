package com.sazcode.domain.usecase

import com.sazcode.domain.abstractrepository.MoviesRepository
import com.sazcode.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke(): List<Movie> {
        return withContext(Dispatchers.IO) {
            repository.getMovies()
        }
    }
}