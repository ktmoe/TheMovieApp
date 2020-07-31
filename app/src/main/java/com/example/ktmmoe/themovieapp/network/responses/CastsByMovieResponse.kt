package com.example.ktmmoe.themovieapp.network.responses

import com.example.ktmmoe.themovieapp.data.vos.CastVO
import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 30, July, 2020
 **/
data class CastsByMovieResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastVO> = emptyList()
)