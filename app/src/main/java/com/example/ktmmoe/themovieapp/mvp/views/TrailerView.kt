package com.example.ktmmoe.themovieapp.mvp.views

import com.example.ktmmoe.shared.mvp.views.BaseView

/**
 * Created by ktmmoe on 01, August, 2020
 **/
interface TrailerView: BaseView {
    fun playVideo(videoKey: String)
    fun showMessageSnackBar(message: String)
}