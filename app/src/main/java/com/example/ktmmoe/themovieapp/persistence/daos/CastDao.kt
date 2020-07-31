package com.example.ktmmoe.themovieapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO

/**
 * Created by ktmmoe on 30, July, 2020
 **/
@Dao
interface CastDao {

    @Query ("select * from casts")
    fun getBestActors() : LiveData<List<CastVO>>

    @Query ("delete from casts")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBestActors (casts: List<CastVO>): List<Long>
}