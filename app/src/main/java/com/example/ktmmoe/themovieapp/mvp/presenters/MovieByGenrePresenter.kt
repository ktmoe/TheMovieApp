package com.example.ktmmoe.themovieapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.ktmmoe.shared.mvp.presenters.BasePresenter
import com.example.ktmmoe.themovieapp.mvp.views.MovieByGenreView
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder

/**
 * Created by ktmmoe on 31, July, 2020
 **/
interface MovieByGenrePresenter : BasePresenter<MovieByGenreView>, MovieViewHolder.MovieDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner, genreId: Int)
}