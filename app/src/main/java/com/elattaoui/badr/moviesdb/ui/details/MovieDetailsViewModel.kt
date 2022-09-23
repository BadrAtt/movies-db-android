package com.elattaoui.badr.moviesdb.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.elattaoui.badr.moviesdb.data.repository.MoviesRepository
import com.elattaoui.badr.moviesdb.data.response.MovieDetailsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    fun fetchMovieDetails(movieId: Int): LiveData<MovieDetailsResult> {
        return liveData {
            moviesRepository.fetchMovieDetails(movieId).collect { result ->
                emit(result)
            }
        }
    }
}
