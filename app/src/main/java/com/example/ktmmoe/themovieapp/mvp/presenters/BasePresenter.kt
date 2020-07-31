package com.example.ktmmoe.themovieapp.mvp.presenters

import com.example.ktmmoe.themovieapp.mvp.views.BaseView

/**
 * Created by ktmmoe on 25, July, 2020
 **/
interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}