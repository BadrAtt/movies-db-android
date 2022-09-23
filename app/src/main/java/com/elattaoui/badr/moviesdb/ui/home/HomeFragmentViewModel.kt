package com.elattaoui.badr.moviesdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elattaoui.badr.moviesdb.data.repository.MoviesRepositoryImpl
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val moviesRepository: MoviesRepositoryImpl
) : ViewModel() {

    private var moviesLiveData: MutableLiveData<MoviesResult> = MutableLiveData()
    val movies: LiveData<MoviesResult> = moviesLiveData

    fun fetchPopularMovies(pageNumber: Int) {
        viewModelScope.launch {
            moviesRepository.fetchPopularMovies(pageNumber).collect { moviesResult ->
                moviesLiveData.value = moviesResult
            }
        }
    }
}
