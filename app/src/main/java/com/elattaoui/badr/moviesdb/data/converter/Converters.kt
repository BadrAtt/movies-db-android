package com.elattaoui.badr.moviesdb.data.converter

import androidx.room.TypeConverter
import com.elattaoui.badr.moviesdb.data.model.Movie
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun getMovieFromString(movieString: String): Movie {
        return Json.decodeFromString(Movie.serializer(), movieString)
    }

    @TypeConverter
    fun getMovieString(movie: Movie): String {
        return Json.encodeToString(Movie.serializer(), movie)
    }
}
