package com.example.ktmmoe.themovieapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO

/**
 * Created by ktmmoe on 30, July, 2020
 **/
@Dao
interface GenreDao {

    @Query ("select * from genre")
    fun getGenres() : LiveData<List<GenreVO>>

    @Query ("delete from genre")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres (genres: List<GenreVO>): List<Long>
}