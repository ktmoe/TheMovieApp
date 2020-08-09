package com.example.ktmmoe.themovieapp.mvp.views

import android.content.Context
import com.example.ktmmoe.shared.mvp.views.BaseView
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.views.viewpods.MovieBackDropInfoViewPod

/**
 * Created by ktmmoe on 29, July, 2020
 **/
interface MovieDetailView: BaseView {
    fun displayMovieDetails(movieDetail: MovieDetailVO)
    fun displayCastsList(movieDetail: MovieDetailVO)
    fun displayCrewsList(movieDetail: MovieDetailVO)
    fun showMessageSnackBar(message: String)

}