package com.example.ktmmoe.themovieapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre")
data class GenreVO(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = ""
)