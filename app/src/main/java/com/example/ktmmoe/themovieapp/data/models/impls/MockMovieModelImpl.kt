package com.example.ktmmoe.themovieapp.data.models.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO

/**
 * Created by ktmmoe on 31, July, 2020
 **/
object MockMovieModelImpl: MovieModel {
    override val movieDetail : MutableLiveData<MovieDetailVO> = MutableLiveData(MovieDetailVO())
    override val moviesByGenre: MutableLiveData<List<MovieVO>> = MutableLiveData(listOf())

    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>> ()
        liveData.postValue(listOf(MovieVO(popular = true), MovieVO(popular = true), MovieVO(popular = true)))
        return liveData
    }

    override fun getGenres(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        val liveData = MutableLiveData<List<GenreVO>> ()
        liveData.postValue(listOf(GenreVO(), GenreVO(), GenreVO()))
        return liveData
    }

    override fun getBestActors(onError: (String) -> Unit): LiveData<List<CastVO>> {
        val liveData = MutableLiveData<List<CastVO>> ()
        liveData.postValue(listOf(CastVO(), CastVO(), CastVO()))
        return liveData
    }

    override fun getMovieDetailById(movieId: Int, onError: (String) -> Unit) {
        movieDetail.postValue(MovieDetailVO(id = movieId))
    }

    override fun getMoviesByGenre(genreId: Int, onError: (String) -> Unit) {
        moviesByGenre.postValue(listOf(MovieVO(), MovieVO(), MovieVO()))
    }

    override fun getAllDataFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {}
}