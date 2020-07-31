package com.example.ktmmoe.themovieapp

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.ktmmoe.themovieapp.data.models.impls.MovieModelImpl
import com.example.ktmmoe.themovieapp.workers.TheMoviePrefetchWorker

/**
 * Created by ktmmoe on 25, July, 2020
 **/
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)

        prefetchDataOneTime()
    }

    private fun prefetchDataOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(TheMoviePrefetchWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}