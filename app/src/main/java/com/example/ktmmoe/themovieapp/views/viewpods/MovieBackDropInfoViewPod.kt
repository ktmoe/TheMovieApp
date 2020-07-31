package com.example.ktmmoe.themovieapp.views.viewpods

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.utils.hourMin
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.backdrop_movie_detail.*
import kotlinx.android.synthetic.main.backdrop_movie_detail.view.*
import kotlinx.android.synthetic.main.viewpod_movie_backdrop_info.*
import kotlinx.android.synthetic.main.viewpod_movie_backdrop_info.view.*
import kotlin.math.floor

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class MovieBackDropInfoViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var mDelegate: Delegate? = null
    private var mData: MovieDetailVO? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setupListeners()
    }

    private fun setupListeners() {
        ivMovieFavourite.setOnClickListener { mDelegate?.onMovieFavouriteClicked(mData?.id ?: 0) }
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun setData(data: MovieDetailVO) {
        mData = data
        ratingBar.rating = floor((data.voteAverage * 0.5).toFloat())
        tvMovieVoting.text = data.voteCount.toString()
        tvMovieRating.text = data.voteAverage.toString()
        tvMovieName.text = data.originalTitle

        tvMovieDuration.text = data.runTime.hourMin()
        bindGenreChips()
    }

    private fun bindGenreChips() {
        val genres = mData?.genres?.map { it.name } ?: emptyList()
        for (index in genres.indices) {
            val chip = Chip(chipGroup.context)
            chip.text= genres[index]
            chip.maxWidth = 8
            chip.minEms = 4
            chip.setTextColor(Color.WHITE)
            chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(chipGroup.context, R.color.colorPrimary))
            chipGroup.addView(chip)
        }
    }

    interface Delegate {
        fun onMovieFavouriteClicked(id: Int)
    }
}