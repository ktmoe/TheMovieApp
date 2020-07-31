package com.example.ktmmoe.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.views.viewholders.CastViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class CastRecyclerAdapter(delegate: CastDelegate): BaseRecyclerAdapter<CastViewHolder, CastVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_person_list, parent, false)
        return CastViewHolder(view, mDelegate)
    }
}