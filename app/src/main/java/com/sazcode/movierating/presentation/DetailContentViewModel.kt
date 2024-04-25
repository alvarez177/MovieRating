package com.sazcode.movierating.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sazcode.domain.usecase.GetMovieCreditsUseCase
import com.sazcode.domain.usecase.MovieDetailUseCase
import com.sazcode.movierating.mapper.toMovieCreditsView
import com.sazcode.movierating.mapper.toMovieDetailView
import com.sazcode.movierating.model.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailContentViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase
) : ViewModel() {

    private val _movieDetailState: MutableLiveData<MovieDetailState> = MutableLiveData()
    val movieDetailState: LiveData<MovieDetailState> = _movieDetailState

    fun getDetailContent(movieId: String) {
        viewModelScope.launch {
            val movieDetail = movieDetailUseCase.invoke(movieId).toMovieDetailView()
            _movieDetailState.value = MovieDetailState(movieDetail)
            val movieCredits = getMovieCreditsUseCase.invoke(movieId)
            val movieDetailWithCredits =
                movieDetail.copy(credits = movieCredits.map { it.toMovieCreditsView() })
            _movieDetailState.value = MovieDetailState(movieDetailWithCredits)
        }
    }
}