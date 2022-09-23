package com.elattaoui.badr.moviesdb.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMoviesFragmentViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {


    fun getFavoriteMovies(): LiveData<List<Movie>> {
        return liveData {
            val favoriteMovies = moviesRepository.getFavoriteMovies()
            emit(favoriteMovies)
        }
    }
}
