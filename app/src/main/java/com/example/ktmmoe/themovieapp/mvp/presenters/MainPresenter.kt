package com.example.ktmmoe.themovieapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.mvp.views.MainView
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder

/**
 * Created by ktmmoe on 31, July, 2020
 **/
interface MainPresenter: BasePresenter<MainView>, MovieViewHolder.MovieDelegate, CastDelegate, CrewDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner)

}