package com.elattaoui.badr.moviesdb.data.repository

import com.elattaoui.badr.moviesdb.data.Api
import com.elattaoui.badr.moviesdb.data.response.MovieDetailsResult
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

@Reusable
class MoviesRepositoryImpl @Inject constructor(
    private val api: Api
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
}
