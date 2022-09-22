package com.elattaoui.badr.moviesdb.data

import com.elattaoui.badr.moviesdb.data.model.Movie
import com.elattaoui.badr.moviesdb.data.response.PageResponse
import retrofit2.http.GET

interface Api {

    @GET("discover/movie")
    suspend fun getPopularMovies(): PageResponse<List<Movie>>
}
