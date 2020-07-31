package com.example.ktmmoe.themovieapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.ktmmoe.themovieapp.data.models.MovieModel
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl

/**
 * Created by ktmmoe on 30, July, 2020
 **/
abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mMovieModel : MovieModel =
        MovieModelImpl
}