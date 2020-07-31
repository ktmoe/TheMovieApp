package com.example.ktmmoe.themovieapp.mvp.views

import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.views.viewpods.MovieBackDropInfoViewPod

/**
 * Created by ktmmoe on 29, July, 2020
 **/
interface MovieDetailView: BaseView {
    fun displayMovieDetails(movieDetail: MovieDetailVO)
    fun showMessageSnackBar(message: String)
}