package com.sazcode.domain.usecase

import com.sazcode.domain.abstractrepository.MoviesRepository
import com.sazcode.domain.model.MovieCredit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke(movieId: String): List<MovieCredit> {
        return withContext(Dispatchers.IO) {
            repository.getCredits(movieId)
        }
    }
}