package com.elattaoui.badr.moviesdb.data.repository

import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.MovieDetailsResult
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun fetchPopularMovies(pageNumber: Int): Flow<MoviesResult>
    fun fetchMovieDetails(movieId: Int): Flow<MovieDetailsResult>
    fun addMovieToFavorites(movie: Movie): Flow<Boolean>
    fun deleteMovieFromFavorites(movie: Movie): Flow<Boolean>
    suspend fun getFavoriteMovies(): List<Movie>
}
