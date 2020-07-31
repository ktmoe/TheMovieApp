package com.example.ktmmoe.themovieapp.workers

import android.content.Context
import androidx.work.WorkerParameters

/**
 * Created by ktmmoe on 30, July, 2020
 **/
class TheMoviePrefetchWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams)  {
    override fun doWork(): Result {
        var result = Result.failure()

        mMovieModel.getAllDataFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )
        return result
    }
}