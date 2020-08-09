package com.example.ktmmoe.themovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ktmmoe.shared.adapters.BaseRecyclerAdapter
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.example.ktmmoe.themovieapp.data.vos.CrewVO
import com.example.ktmmoe.themovieapp.delegates.CastDelegate
import com.example.ktmmoe.themovieapp.delegates.CrewDelegate
import com.example.ktmmoe.themovieapp.views.viewholders.CastViewHolder
import com.example.ktmmoe.themovieapp.views.viewholders.CrewViewHolder

/**
 * Created by ktmmoe on 29, July, 2020
 **/
class CrewRecyclerAdapter(private val delegate: CrewDelegate): BaseRecyclerAdapter<CrewViewHolder, CrewVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_person_list, parent, false)
        return CrewViewHolder(view, delegate)
    }
}