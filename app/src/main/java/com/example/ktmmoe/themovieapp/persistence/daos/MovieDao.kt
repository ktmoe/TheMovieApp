package com.example.ktmmoe.themovieapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ktmmoe.themovieapp.data.vos.MovieVO

/**
 * Created by ktmmoe on 30, July, 2020
 **/
@Dao
interface MovieDao {

    @Query ("select * from movies where popular = :p")
    fun getPopularMovie(p: Boolean = true) : LiveData<List<MovieVO>>

    @Query("select * from movies")
    fun getMovies(): LiveData<List<MovieVO>>

    @Query ("delete from movies where popular = :popular")
    fun deleteAllPopular(popular: Boolean = true)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies (movies: List<MovieVO>)
}