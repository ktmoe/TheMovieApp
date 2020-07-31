package com.example.ktmmoe.themovieapp.network.responses

import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 30, July, 2020
 **/
data class MoviesByGenreResponse(
    @SerializedName("results") val results: List<MovieVO> = emptyList()
)