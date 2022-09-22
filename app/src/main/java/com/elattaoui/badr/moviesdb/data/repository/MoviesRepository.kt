package com.elattaoui.badr.moviesdb.data.repository

import com.elattaoui.badr.moviesdb.data.Api
import com.elattaoui.badr.moviesdb.data.response.MoviesResult
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

@Reusable
class MoviesRepository @Inject constructor(
    private val api: Api
) {

    fun fetchPopularMovies(): Flow<MoviesResult> {
        return flow<MoviesResult> {
            val networkResult = api.getPopularMovies()
            emit(
                MoviesResult.Success(networkResult.results)
            )
        }.catch { exception ->
            emit(MoviesResult.Error(exception))
        }.onStart { emit(MoviesResult.Loading) }
    }
}
