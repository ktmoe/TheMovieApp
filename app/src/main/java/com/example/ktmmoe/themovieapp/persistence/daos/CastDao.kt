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

    @Query ("select * from casts where goodActor = :good")
    fun getBestActors(good: Boolean = true) : LiveData<List<CastVO>>

    @Query("update casts set favourite = :favourite where id = :id")
    fun favouriteActor(id: Int, favourite: Boolean = true)

    @Query ("delete from casts")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActors (casts: List<CastVO>): List<Long>
}