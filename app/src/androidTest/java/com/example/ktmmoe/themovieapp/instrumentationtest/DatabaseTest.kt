package com.example.ktmmoe.themovieapp.instrumentationtest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.persistence.daos.CastDao
import com.example.ktmmoe.themovieapp.persistence.daos.GenreDao
import com.example.ktmmoe.themovieapp.persistence.daos.MovieDao
import com.example.ktmmoe.themovieapp.persistence.db.MovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ktmmoe on 31, July, 2020
 **/
@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var movieDao: MovieDao
    private lateinit var castDao: CastDao
    private lateinit var genreDao: GenreDao

    private lateinit var db: MovieDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MovieDB::class.java).build()

        movieDao = db.movieDao()
        castDao = db.castDao()
        genreDao = db.genreDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        val mockMovies = listOf(MovieVO(id = 2), MovieVO(id = 3), MovieVO(id = 4))
        val mockCasts = listOf(CastVO(id = 1), CastVO(id = 2), CastVO(id = 3))
        val mockGenres = listOf(GenreVO(id = 1), GenreVO(id = 2), GenreVO(id = 3))

        movieDao.insertMovies(mockMovies)
        castDao.insertBestActors(mockCasts)
        genreDao.insertGenres(mockGenres)

        assert(movieDao.getMovies().value?.count() == mockMovies.count())
        assert(castDao.getBestActors().value?.count() == mockCasts.count())
        assert(genreDao.getGenres().value?.count() == mockGenres.count())
    }
}