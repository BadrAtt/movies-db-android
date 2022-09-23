package com.elattaoui.badr.moviesdb.data.repository

import com.elattaoui.badr.moviesdb.data.Api
import com.elattaoui.badr.moviesdb.data.dao.FavoriteMoviesDAO
import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.MovieDetailsResult
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

@Reusable
class MoviesRepositoryImpl @Inject constructor(
    private val api: Api,
    private val favoriteMoviesDAO: FavoriteMoviesDAO
) : MoviesRepository {

    override fun fetchPopularMovies(pageNumber: Int): Flow<MoviesResult> {
        return flow<MoviesResult> {
            val networkResult = api.getPopularMovies(pageNumber)
            emit(
                MoviesResult.Success(networkResult.results)
            )
        }.catch { exception ->
            emit(MoviesResult.Error(exception))
        }.onStart { emit(MoviesResult.Loading) }
    }

    override fun fetchMovieDetails(movieId: Int): Flow<MovieDetailsResult> {
        return flow<MovieDetailsResult> {
            val networkResult = api.getMovieDetails(movieId)
            emit(
                MovieDetailsResult.Success(networkResult)
            )
        }.catch { exception ->
            emit(MovieDetailsResult.Error(exception))
        }.onStart { emit(MovieDetailsResult.Loading) }
    }

    override fun addMovieToFavorites(movie: Movie): Flow<Boolean> {
        return flow {
            favoriteMoviesDAO.addMovieToFavorites(movie)
            emit(true)
        }.catch {
            emit(false)
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteMovieFromFavorites(movie: Movie): Flow<Boolean> {
        return flow {
            favoriteMoviesDAO.deleteFavoriteMovieById(movie.id)
            emit(true)
        }.catch {
            emit(false)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getFavoriteMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            favoriteMoviesDAO.getFavoriteMovies() ?: emptyList()
        }
    }
}
