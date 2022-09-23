package com.elattaoui.badr.moviesdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elattaoui.badr.moviesdb.data.converter.Converters
import com.elattaoui.badr.moviesdb.data.dao.FavoriteMoviesDAO
import com.elattaoui.badr.moviesdb.data.model.Movie

@Database(
    entities = [Movie::class],
    version = 1,
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun favoriteMoviesDao(): FavoriteMoviesDAO
}
