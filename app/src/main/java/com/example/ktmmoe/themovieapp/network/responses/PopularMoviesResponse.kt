package com.example.ktmmoe.themovieapp.network.responses

import com.example.ktmmoe.themovieapp.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 30, July, 2020
 **/
data class PopularMoviesResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<MovieVO> = emptyList(),
    @SerializedName("total_pages") val totalPages: Int = 0,
    @SerializedName("total_results") val totalResults: Int = 0
)