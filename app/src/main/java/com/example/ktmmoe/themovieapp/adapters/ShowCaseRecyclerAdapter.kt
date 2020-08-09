package com.example.ktmmoe.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.shared.adapters.BaseRecyclerAdapter
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.views.viewholders.ShowCaseViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class ShowCaseRecyclerAdapter : BaseRecyclerAdapter<ShowCaseViewHolder, String>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_showcases, parent, false)
        return ShowCaseViewHolder(view)
    }

}