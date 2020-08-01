package com.example.ktmmoe.themovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.views.viewholders.SliderAdapterViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by ktmmoe on 28, July, 2020
 **/
class SliderAdapter(private val context : Context, private val delegate: SliderAdapterViewHolder.Delegate)
    : SliderViewAdapter<SliderAdapterViewHolder>() {
    private var movies : List<MovieVO> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_play_video, parent, false)
        return SliderAdapterViewHolder(view, context, delegate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterViewHolder?, position: Int) {
        viewHolder?.bind(movies[position])
    }

    override fun getCount(): Int = movies.size

    fun addMovieList(movies: List<MovieVO>){
        this.movies = movies
        notifyDataSetChanged()
    }

}