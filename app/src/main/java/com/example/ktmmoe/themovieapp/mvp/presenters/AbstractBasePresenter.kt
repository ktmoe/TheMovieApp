package com.example.ktmmoe.themovieapp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.ktmmoe.themovieapp.mvp.views.BaseView

/**
 * Created by ktmmoe on 25, July, 2020
 **/
abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}