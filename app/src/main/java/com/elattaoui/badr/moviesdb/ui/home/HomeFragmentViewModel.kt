package com.elattaoui.badr.moviesdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elattaoui.badr.moviesdb.data.model.Movie
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

    private var updatedMovieLiveData: MutableLiveData<Movie> = MutableLiveData()
    val updatedMovie: LiveData<Movie> = updatedMovieLiveData


    fun fetchPopularMovies(pageNumber: Int) {
        viewModelScope.launch {
            moviesRepository.fetchPopularMovies(pageNumber).collect { moviesResult ->
                moviesLiveData.value = moviesResult
            }
        }
    }

    fun handleFavoriteMovie(movie: Movie) {
        viewModelScope.launch {
            if (movie.isFavorite) {
                moviesRepository.deleteMovieFromFavorites(movie.apply { isFavorite = false })
                    .collect { isFavorite ->
                        movie.isFavorite = isFavorite
                    }
            } else {
                moviesRepository.addMovieToFavorites(movie.apply { isFavorite = true })
                    .collect { isFavorite ->
                        movie.isFavorite = isFavorite
                    }
            }
            updatedMovieLiveData.value = movie
        }
    }
}
