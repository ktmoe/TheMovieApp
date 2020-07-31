package com.example.ktmmoe.themovieapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ktmmoe.themovieapp.R
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import com.google.gson.annotations.SerializedName

@Entity(tableName = "casts")
data class CastVO(
    @SerializedName("cast_id") val castId: Int = 1,
    @SerializedName("character") val character: String = "",
    @SerializedName("credit_id") val creditId: String = "",
    @SerializedName("gender") val gender: Int = 0,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("order") val order: Int = 0,
    @SerializedName("profile_path") val profilePath: String? = ""
) {
    var favourite: Boolean = false
    fun favouriteDrawable(): Int = if (favourite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
    fun actualProfilePath(): String = BASE_IMAGE_URL + profilePath
}

