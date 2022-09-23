package com.elattaoui.badr.moviesdb.data

import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.PageResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun getPopularMovies(
        @Query("page") pageNumber: Int
    ): PageResponse<List<Movie>>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): Movie
}
