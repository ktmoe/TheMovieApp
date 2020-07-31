package com.example.ktmmoe.themovieapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by ktmmoe on 30, July, 2020
 **/
class IntListTypeConverter {
    @TypeConverter
    fun toString(list: List<Int>) : String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toIntList(listJson: String): List<Int> {
        val listType = object : TypeToken<List<Int>> () {}.type
        return Gson().fromJson(listJson, listType)
    }
}