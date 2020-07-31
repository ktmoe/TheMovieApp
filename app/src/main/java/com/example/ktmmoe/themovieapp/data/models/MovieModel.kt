package com.example.ktmmoe.themovieapp.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO

/**
 * Created by ktmmoe on 30, July, 2020
 **/

interface MovieModel {
    val movieDetail : MutableLiveData<MovieDetailVO>
    val moviesByGenre: MutableLiveData<List<MovieVO>>

    fun getPopularMovies(onError: (String) -> Unit) : LiveData<List<MovieVO>>

    fun getGenres(onError: (String) -> Unit) : LiveData<List<GenreVO>>

    fun getBestActors(onError: (String) -> Unit) : LiveData<List<CastVO>>

    fun getMovieDetailById (movieId: Int, onError: (String) -> Unit)

    fun getMoviesByGenre(genreId: Int, onError: (String) -> Unit)

    fun getAllDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
}