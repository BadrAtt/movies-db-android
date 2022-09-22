package com.elattaoui.badr.moviesdb.data.response

import com.elattaoui.badr.moviesdb.data.model.Movie

sealed class MoviesResult {
    data class Success(val data: List<Movie>) : MoviesResult()
    data class Error(val exception: Throwable) : MoviesResult()
    object Loading : MoviesResult()
}
