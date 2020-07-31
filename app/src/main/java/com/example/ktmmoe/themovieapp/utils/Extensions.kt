package com.example.ktmmoe.themovieapp.utils

/**
 * Created by ktmmoe on 31, July, 2020
 **/
fun Int.hourMin() : String = "${this/60}hr ${this%60}min"