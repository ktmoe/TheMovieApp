package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.mvp.presenters.AbstractBasePresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.MovieDetailPresenter
import com.example.ktmmoe.themovieapp.mvp.views.MainView
import com.example.ktmmoe.themovieapp.mvp.views.MovieDetailView

/**
 * Created by ktmmoe on 31, July, 2020
 **/
class MovieDetailPresenterImpl: MovieDetailPresenter, AbstractBasePresenter<MovieDetailView>() {
    var mMovieModel: MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        //network call here
        setupObservations(lifecycleOwner)

        getMovieDetail(movieId)

    }

    override fun onMovieFavouriteClicked(id: Int) {
        mView?.showMessageSnackBar("Favourite on Movie Clicked")
    }

    override fun onCastFavouriteClicked(id: Int) {
        mView?.showMessageSnackBar("Favourite on Cast Clicked")
    }

    override fun onCrewFavouriteClicked(id: Int) {
        mView?.showMessageSnackBar("Favourite on Crew Clicked")
    }

    private fun getMovieDetail(movieId: Int) {
        mView?.showLoading()
        mMovieModel.getMovieDetailById(movieId){
            mView?.hideLoading()
            mView?.showMessageSnackBar(it)
        }
    }

    private fun setupObservations(lifecycleOwner: LifecycleOwner) {
        mMovieModel.movieDetail.observe(lifecycleOwner, Observer {
            mView?.hideLoading()
            if (it.id != 0) {
                mView?.displayMovieDetails(it)
                mView?.displayCastsList(it)
                mView?.displayCrewsList(it)
            }
        })
    }
}