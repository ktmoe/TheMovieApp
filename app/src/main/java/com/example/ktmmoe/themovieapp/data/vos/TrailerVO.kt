package com.example.ktmmoe.themovieapp.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 01, August, 2020
 **/
data class TrailerVO(
    @SerializedName("id") val id: String = "",
    @SerializedName("key") val key: String = ""
)