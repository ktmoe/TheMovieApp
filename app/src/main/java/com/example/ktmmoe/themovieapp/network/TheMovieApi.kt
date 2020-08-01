package com.example.ktmmoe.themovieapp.network

import com.example.ktmmoe.themovieapp.data.vos.MovieDetailVO
import com.example.ktmmoe.themovieapp.network.responses.*
import com.example.ktmmoe.themovieapp.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ktmmoe on 30, July, 2020
 **/
interface TheMovieApi {

    @GET(POPULAR_MOVIE)
    fun getPopularMovies(@Query("api_key") apiKey: String = PARAM_API_KEY) : Observable<PopularMoviesResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetail(
        @Path("MOVIE_ID") movieID: Int,
        @Query("api_key") apiKey: String = PARAM_API_KEY,
        @Query("append_to_response") appendToResponse: String = "credits"
    ): Observable<MovieDetailVO>

    @GET(MOVIE_GENRES)
    fun getMovieGenres(@Query("api_key") apiKey: String = PARAM_API_KEY): Observable<GenresResponse>

    @GET(MOVIE_BY_GENRE)
    fun getMoviesByGenre(
        @Query("api_key") apiKey: String = PARAM_API_KEY,
        @Query("with_genres") genreId: Int
    ): Observable<MoviesByGenreResponse>

    @GET(MOVIE_CASTS)
    fun getBestActors(@Query("api_key") apiKey: String = PARAM_API_KEY) : Observable<CastsByMovieResponse>

    @GET("$MOVIE_DETAIL/{MOVIE_ID}/videos")
    fun getTrailersByMovie(
        @Path("MOVIE_ID") movieID: Int,
        @Query("api_key") apiKey: String = PARAM_API_KEY
    ): Observable<TrailersByMovieResponse>

}