package com.example.ktmmoe.themovieapp.views.viewholders

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.CrewVO
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.layout_item_person_list.view.*

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class CrewViewHolder(itemView: View, delegate: CrewDelegate) : BaseViewHolder<CrewVO>(itemView) {

    private lateinit var mIvPerson: AppCompatImageView
    init {
        itemView.ivPersonFavourite.setOnClickListener { delegate.onCrewFavouriteClicked(mData?.id ?: 0) }
    }

    override fun bindData(data: CrewVO) {
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