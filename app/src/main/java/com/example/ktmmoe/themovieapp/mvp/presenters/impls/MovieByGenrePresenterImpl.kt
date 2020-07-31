package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.mvp.presenters.AbstractBasePresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.MovieByGenrePresenter
import com.example.ktmmoe.themovieapp.mvp.views.MovieByGenreView

/**
 * Created by ktmmoe on 31, July, 2020
 **/
class MovieByGenrePresenterImpl: MovieByGenrePresenter, AbstractBasePresenter<MovieByGenreView>() {
    var mMovieModel: MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, genreId: Int) {
        //network call here
        setupObservations(lifecycleOwner)
        getMoviesByGenre(genreId)
    }

    override fun onMovieClicked(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

    private fun getMoviesByGenre(genreId: Int) {
        mMovieModel.getMoviesByGenre(genreId){
            mView?.showMessageSnackBar(it)
        }
    }

    private fun setupObservations(lifecycleOwner: LifecycleOwner) {
        mMovieModel.moviesByGenre.observe(lifecycleOwner, Observer {
            mView?.displayMoviesList(it.toMutableList())
        })
    }
}