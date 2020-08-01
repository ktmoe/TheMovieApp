package com.example.ktmmoe.themovieapp.mvp.views

import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
interface MainView: BaseView{
    fun displayTop5(list: MutableList<MovieVO>)
    fun displayMoviesList(list: MutableList<MovieVO>)
    fun displayGenresList (list: MutableList<GenreVO>)
    fun displayBestActorsList(list: MutableList<CastVO>)
    fun navigateToMovieDetail(movieId: Int)
    fun navigateToTrailerActivity(movieId: Int)
    fun showMessageSnackBar(message:String)
}