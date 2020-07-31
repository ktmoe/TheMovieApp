package com.example.ktmmoe.themovieapp.data.models

import android.content.Context
import com.example.ktmmoe.themovieapp.network.TheMovieApi
import com.example.ktmmoe.themovieapp.persistence.db.MovieDB
import com.example.ktmmoe.themovieapp.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.log

/**
 * Created by ktmmoe on 30, July, 2020
 **/
abstract class BaseModel {

    protected var mTheMovieApi: TheMovieApi
    protected lateinit var mTheMovieDB: MovieDB

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mTheMovieApi = retrofit.create(TheMovieApi::class.java)
    }

    fun initDatabase(context: Context) {
        mTheMovieDB = MovieDB.getDBInstance(context)
    }
}