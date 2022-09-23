package com.elattaoui.badr.moviesdb.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elattaoui.badr.moviesdb.data.model.Movie

@Dao
interface FavoriteMoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieToFavorites(favoriteMovie: Movie)

    @Query("SELECT * FROM favorites ORDER BY Id DESC")
    fun getFavoriteMovies(): List<Movie>?

    @Query("DELETE FROM favorites WHERE id = :id")
    fun deleteFavoriteMovieById(id: Int)
}
