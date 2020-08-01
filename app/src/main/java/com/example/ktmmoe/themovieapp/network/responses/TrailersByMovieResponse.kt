package com.example.ktmmoe.themovieapp.network.responses

import com.example.ktmmoe.themovieapp.data.vos.TrailerVO
import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 01, August, 2020
 **/
data class TrailersByMovieResponse (
    @SerializedName("id") val id: String,
    @SerializedName("results") val results: List<TrailerVO>
)