package com.elattaoui.badr.moviesdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.elattaoui.badr.moviesdb.ui.data.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor() : ViewModel() {

    val movies: LiveData<List<Movie>> = liveData {
        val moviesList = arrayListOf<Movie>()
        var initialMovieId = 0
        repeat(20) {
            val movie = Movie(
                id = initialMovieId++,
                voteAverage = 4.5,
                voteCount = 500,
                title = "Hello World",
                posterPath = "/kxB9E6fo0ycHzd13oOTHmGa5Njd.jpg"
            )
            moviesList.add(movie)
        }
        emit(moviesList)
    }
}
