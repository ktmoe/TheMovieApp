package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import androidx.lifecycle.Observer
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.mvp.presenters.AbstractBasePresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.TrailerPresenter
import com.example.ktmmoe.themovieapp.mvp.views.TrailerView

/**
 * Created by ktmmoe on 01, August, 2020
 **/
class TrailerPresenterImpl: TrailerPresenter, AbstractBasePresenter<TrailerView>() {
    var mMovieModel: MovieModel = MovieModelImpl

    override fun onUiReady(movieId: Int) {
        setupObservations()
        mMovieModel.getTrailersByMovie(movieId)  {
            mView?.showMessageSnackBar(it)
        }
    }

    private fun setupObservations() {
        mView?.let {view->
            mMovieModel.trailerByMovie.observe(view.getOwner(), Observer {
                view.playVideo(it.key)
            })
        }
    }
}