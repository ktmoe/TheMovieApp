package com.example.ktmmoe.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.views.viewholders.MovieViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class MovieRecyclerAdapter(delegate: MovieViewHolder.MovieDelegate): BaseRecyclerAdapter<MovieViewHolder, MovieVO>() {

    private val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_movie_list, parent, false)
        return MovieViewHolder(view, mDelegate)
    }

}