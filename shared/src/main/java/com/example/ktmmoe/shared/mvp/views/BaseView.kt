package com.example.ktmmoe.shared.mvp.views

import androidx.lifecycle.LifecycleOwner

/**
 * Created by ktmmoe on 25, July, 2020
 **/
interface BaseView{
    fun getOwner():LifecycleOwner
    fun showLoading()
    fun hideLoading()
}