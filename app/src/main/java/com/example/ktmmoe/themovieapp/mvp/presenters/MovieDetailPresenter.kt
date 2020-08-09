package com.example.ktmmoe.themovieapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.shared.mvp.presenters.BasePresenter
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.mvp.views.MovieDetailView
import com.example.ktmmoe.themovieapp.views.viewpods.MovieBackDropInfoViewPod

/**
 * Created by ktmmoe on 31, July, 2020
 **/
interface MovieDetailPresenter: BasePresenter<MovieDetailView>, MovieBackDropInfoViewPod.Delegate,
    CastDelegate, CrewDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int)
}