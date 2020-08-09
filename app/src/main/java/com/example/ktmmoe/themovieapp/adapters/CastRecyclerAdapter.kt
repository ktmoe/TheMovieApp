package com.example.ktmmoe.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.shared.adapters.BaseRecyclerAdapter
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.views.viewholders.CastViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class CastRecyclerAdapter(private val delegate: CastDelegate): BaseRecyclerAdapter<CastViewHolder, CastVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_person_list, parent, false)
        return CastViewHolder(view, delegate)
    }
}