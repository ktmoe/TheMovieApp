package com.example.ktmmoe.themovieapp.mvp.views

import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
interface MovieByGenreView: BaseView {
    fun displayMoviesList(list: MutableList<MovieVO>)
    fun navigateToMovieDetail(movieId: Int)
    fun showMessageSnackBar(message: String)
}