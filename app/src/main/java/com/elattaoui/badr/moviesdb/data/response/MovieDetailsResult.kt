package com.elattaoui.badr.moviesdb.data.response

import com.elattaoui.badr.moviesdb.data.model.Movie

sealed class MovieDetailsResult {
    data class Success(val data: Movie) : MovieDetailsResult()
    data class Error(val exception: Throwable) : MovieDetailsResult()
    object Loading : MovieDetailsResult()
}
