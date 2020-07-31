package com.example.ktmmoe.themovieapp.views.viewholders

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class ShowCaseViewHolder(itemView: View): BaseViewHolder<String>(itemView) {
    private lateinit var mImageView : AppCompatImageView

    override fun bindData(data: String) {
        mData = data
        mImageView = itemView.findViewById(R.id.ivMoviePoster)
        Glide.with(itemView.context)
            .load("$BASE_IMAGE_URL/c18HVnKTybcAUYVQd8rOcdbqwY.jpg")
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
            .into(mImageView)
    }
}