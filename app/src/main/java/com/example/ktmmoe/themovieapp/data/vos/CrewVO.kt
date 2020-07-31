package com.example.ktmmoe.themovieapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL

data class CrewVO(
    @SerializedName("credit_id") val creditId: String= "",
    @SerializedName("department") val department: String = "",
    @SerializedName("gender") val gender: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("job") val job: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("profile_path") val profilePath: String = ""
) {
    var favourite: Boolean = false
    fun favouriteDrawable(): Int = if (favourite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
    fun actualProfilePath(): String = BASE_IMAGE_URL + profilePath
}