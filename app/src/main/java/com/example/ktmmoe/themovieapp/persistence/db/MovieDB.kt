package com.example.ktmmoe.themovieapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.CrewVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.persistence.daos.CastDao
import com.example.ktmmoe.themovieapp.persistence.daos.GenreDao
import com.example.ktmmoe.themovieapp.persistence.daos.MovieDao

/**
 * Created by ktmmoe on 30, July, 2020
 **/
@Database(entities = [MovieVO::class, GenreVO::class, CastVO::class], version = 1, exportSchema = false)
abstract class MovieDB: RoomDatabase() {

    companion object {
        val DB_NAME = "MOVIE.DB"
        var dbInstance: MovieDB? = null

        fun getDBInstance (context: Context) : MovieDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun movieDao() : MovieDao
    abstract fun castDao(): CastDao
    abstract fun genreDao(): GenreDao
}