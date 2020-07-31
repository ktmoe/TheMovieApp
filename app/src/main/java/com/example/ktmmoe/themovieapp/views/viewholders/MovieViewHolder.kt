package com.example.ktmmoe.themovieapp.views.viewholders

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.layout_item_movie_list.view.*
import kotlin.math.floor

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class MovieViewHolder(itemView: View, delegate: MovieDelegate): BaseViewHolder<MovieVO>(itemView) {
    private lateinit var mIvMovie: AppCompatImageView

    init {
        itemView.setOnClickListener { delegate.onMovieClicked(mData?.id?:0) }
    }
    override fun bindData(data: MovieVO) {
        mData = data
        mIvMovie = itemView.findViewById(R.id.ivMovie)
        Glide.with(itemView.context)
            .load(data.actualPosterPath())
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
            .into(mIvMovie)
        itemView.tvMovieName.text = data.title
        itemView.tvMovieRating.text = data.voteAverage.toString()
        itemView.ratingBar.rating = floor((data.voteAverage * 0.5).toFloat())
    }

    interface MovieDelegate {
        fun onMovieClicked(id: Int)
    }
}