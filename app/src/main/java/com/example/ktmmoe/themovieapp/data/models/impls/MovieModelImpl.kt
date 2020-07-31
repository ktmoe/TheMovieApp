package com.example.ktmmoe.themovieapp.data.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ktmmoe.themovieapp.data.models.BaseModel
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.network.responses.CastsByMovieResponse
import com.example.ktmmoe.themovieapp.network.responses.GenresResponse
import com.example.ktmmoe.themovieapp.network.responses.PopularMoviesResponse
import com.example.ktmmoe.themovieapp.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

/**
 * Created by ktmmoe on 30, July, 2020
 **/
object MovieModelImpl: MovieModel, BaseModel() {
    override val movieDetail: MutableLiveData<MovieDetailVO> = MutableLiveData()
    override val moviesByGenre: MutableLiveData<List<MovieVO>> = MutableLiveData(listOf())

    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheMovieDB.movieDao().getPopularMovie()
    }

    override fun getGenres(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mTheMovieDB.genreDao().getGenres()
    }

    override fun getBestActors(onError: (String) -> Unit): LiveData<List<CastVO>> {
        return mTheMovieDB.castDao().getBestActors()
    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailById(movieId: Int, onError: (String) -> Unit) {
        mTheMovieApi.getMovieDetail(movieID = movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieDetail.postValue(it)
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getMoviesByGenre(genreId: Int, onError: (String) -> Unit) {
        mTheMovieApi.getMoviesByGenre(genreId = genreId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                moviesByGenre.postValue(it.results)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getAllDataFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        var popularMovies: List<MovieVO> = listOf()
        var genres: List<GenreVO> = listOf()
        var bestActors: List<CastVO> = listOf()
        Observable.zip(
            mTheMovieApi.getPopularMovies(),
            mTheMovieApi.getMovieGenres(),
            mTheMovieApi.getBestActors(),
            Function3<PopularMoviesResponse, GenresResponse, CastsByMovieResponse, Unit>{t1, t2, t3 ->
                popularMovies = t1.results.map { it.copy(popular = true) }
                genres = t2.genres
                bestActors = t3.cast
            }
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val g = mTheMovieDB.genreDao().insertGenres(genres)
                val a = mTheMovieDB.castDao().insertBestActors(bestActors)

                mTheMovieDB.movieDao().insertMovies(popularMovies)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }
}