package com.example.ktmmoe.themovieapp.mvp.presenters

import com.example.ktmmoe.themovieapp.mvp.views.TrailerView

/**
 * Created by ktmmoe on 01, August, 2020
 **/
interface TrailerPresenter: BasePresenter<TrailerView>{
    fun onUiReady(movieId: Int)
}