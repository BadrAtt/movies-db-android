package com.elattaoui.badr.moviesdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elattaoui.badr.moviesdb.data.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    moviesRepository: MoviesRepository
) : ViewModel() {

    val movies = moviesRepository.fetchPopularMovies().asLiveData()
}
