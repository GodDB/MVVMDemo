package com.example.mvvmdemo.network.service

import com.godgod.data.network.model.MovieDetailModel
import com.godgod.data.network.model.TrendingMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * movie api service
 * */
interface MovieService {

    @GET("/3/trending/movie/week")
    suspend fun getPopularMovies(): TrendingMovieResponse

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieDetailModel
}