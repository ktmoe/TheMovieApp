package com.example.ktmmoe.themovieapp.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.mvp.presenters.AbstractBasePresenter
import com.example.ktmmoe.themovieapp.mvp.presenters.MainPresenter
import com.example.ktmmoe.themovieapp.mvp.views.MainView

/**
 * Created by ktmmoe on 31, July, 2020
 **/
class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {

    var mMovieModel: MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        //request data here
        loadPrerequisiteData(lifecycleOwner)
    }

    override fun onMovieClicked(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

    override fun onCastFavouriteClicked(id: Int) {
        mView?.showMessageSnackBar("Favourite on Cast is clicked")
    }

    override fun onCrewFavouriteClicked(id: Int) {
        mView?.showMessageSnackBar("Favourite on Crew is clicked")
    }

    override fun onTapMovieSlider(movieId: Int) {
        mView?.navigateToTrailerActivity(movieId)
    }

    private fun loadPrerequisiteData(lifecycleOwner: LifecycleOwner) {
        mView?.showLoading()
        mMovieModel.getPopularMovies {
            mView?.showMessageSnackBar(it)
        }.observe(lifecycleOwner, Observer {
            mView?.displayMoviesList(it.toMutableList())
            if (it.count() > 5)
                mView?.displayTop5(it.subList(0, 4).toMutableList())
        })
        mMovieModel.getGenres { mView?.showMessageSnackBar(it) }
            .observe(lifecycleOwner, Observer {
                mView?.displayGenresList(it.toMutableList())
            })
        mMovieModel.getBestActors { mView?.showMessageSnackBar(it) }
            .observe(lifecycleOwner, Observer {
                mView?.displayBestActorsList(it.toMutableList())
            })
        mView?.hideLoading()
    }
}