package com.sazcode.movierating

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sazcode.domain.model.Movie
import com.sazcode.domain.usecase.GetMoviesUseCase
import com.sazcode.movierating.mapper.toMovieView
import com.sazcode.movierating.model.ContentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VisualizeContentViewModel @Inject constructor(private val getMovies: GetMoviesUseCase) :
    ViewModel() {

    init {
        getMovies()
    }

    private val _contentState: MutableLiveData<ContentState> = MutableLiveData()
    val contentState: LiveData<ContentState> = _contentState


    fun getMovies() {
        viewModelScope.launch {
            val movies: List<Movie> = getMovies.invoke()
            _contentState.value = (ContentState(movies.map { it.toMovieView() }))
        }
    }
}