package com.example.ktmmoe.themovieapp.views.viewholders

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.shared.views.viewholders.BaseViewHolder
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.layout_item_person_list.view.*

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class CastViewHolder(itemView: View, delegate: CastDelegate) : BaseViewHolder<CastVO>(itemView) {
    private lateinit var mIvPerson: AppCompatImageView

    init {
        itemView.ivPersonFavourite.setOnClickListener { delegate.onCastFavouriteClicked(it?.id ?: 0) }
    }

    override fun bindData(data: CastVO) {
        mData = data
        mIvPerson = itemView.findViewById(R.id.ivPerson)
        Glide.with(itemView.context)
            .load(data.actualProfilePath())
            .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
            .into(mIvPerson)
        itemView.ivPersonFavourite.setImageResource(data.favouriteDrawable())
        itemView.tvPersonName.text = data.name
    }
}