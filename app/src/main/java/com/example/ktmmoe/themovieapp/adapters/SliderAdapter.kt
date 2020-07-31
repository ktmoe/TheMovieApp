package com.example.ktmmoe.themovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by ktmmoe on 28, July, 2020
 **/
class SliderAdapter(private val context : Context)
    : SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder>() {
    private var urlList : List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_play_video, parent, false)
        return SliderAdapterViewHolder(view, context)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterViewHolder?, position: Int) {
        viewHolder?.bind(urlList[position])
    }

    override fun getCount(): Int = urlList.size

    fun addUrlList(urlList: List<String>){
        this.urlList = urlList
        notifyDataSetChanged()
    }

    class SliderAdapterViewHolder(private val itemView: View?,
                                  private val context: Context)
        : SliderViewAdapter.ViewHolder(itemView){

        private lateinit var mImageView : AppCompatImageView

        fun bind(url : String){
            mImageView = itemView!!.findViewById(R.id.ivMoviePoster)
            Glide.with(context)
                .load(BASE_IMAGE_URL + url)
                .apply(RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).centerCrop())
                .into(mImageView)
        }
    }
}