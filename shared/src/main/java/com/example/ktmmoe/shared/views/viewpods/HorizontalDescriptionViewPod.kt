package com.example.ktmmoe.shared.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.viewpod_horizontal_description.view.*

/**
 * Created by ktmmoe on 30, July, 2020
 **/
class HorizontalDescriptionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun titleAndDescription (title: String, description: String) {
        tvViewPodTitle.text = title
        tvViewPodDescription.text = description
    }

}