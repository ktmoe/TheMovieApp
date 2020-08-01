package com.example.ktmmoe.themovieapp.views.viewholders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by ktmmoe on 01, August, 2020
 **/
class SliderAdapterViewHolder(
    private val itemView: View?,
    private val context: Context,
    private val delegate: Delegate
) : SliderViewAdapter.ViewHolder(itemView) {

    private lateinit var mImageView: AppCompatImageView
    private lateinit var mData: MovieVO

    init {
        itemView?.setOnClickListener {
            delegate.onTapMovieSlider(mData.id)
        }
    }

    fun bind(data: MovieVO) {
        mData = data
        mImageView = itemView!!.findViewById(R.id.ivMoviePoster)
        Glide.with(context)
            .load(data.actualBackdropPath())
            .apply(
                RequestOptions().placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).centerCrop()
            )
            .into(mImageView)
    }

    interface Delegate {
        fun onTapMovieSlider(movieId: Int)
    }
}