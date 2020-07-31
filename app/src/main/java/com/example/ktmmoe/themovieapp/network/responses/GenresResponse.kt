package com.example.ktmmoe.themovieapp.network.responses

import com.example.ktmmoe.themovieapp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 30, July, 2020
 **/
data class GenresResponse(
    @SerializedName("genres") val genres: List<GenreVO> = emptyList()
)