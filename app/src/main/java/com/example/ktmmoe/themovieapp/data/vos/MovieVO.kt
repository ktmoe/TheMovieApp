package com.example.ktmmoe.themovieapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.ktmmoe.themovieapp.persistence.typeconverters.IntListTypeConverter
import com.example.ktmmoe.themovieapp.utils.BASE_IMAGE_URL
import com.google.gson.annotations.SerializedName


@Entity(tableName = "movies")
@TypeConverters(IntListTypeConverter::class)
data class MovieVO(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String = "",
    @SerializedName("genre_ids") val genreIds: List<Int> = emptyList(),
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: Double = 0.0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("vote_count") val voteCount: Int = 0,
    var popular: Boolean = false
) {
    fun actualBackdropPath() = BASE_IMAGE_URL + backdropPath
    fun actualPosterPath() = BASE_IMAGE_URL + posterPath
}