package com.example.mvvmdemo.network

import android.util.Log
import com.example.mvvmdemo.base.BaseDataSource
import com.example.mvvmdemo.model.Result
import com.example.mvvmdemo.network.model.MovieDetailModel
import com.example.mvvmdemo.network.model.TrendingMovieResponse
import com.example.mvvmdemo.network.service.MovieService
import javax.inject.Inject
import javax.inject.Singleton

interface MovieDataSource : BaseDataSource {

    suspend fun getPopularMovies(): Result<TrendingMovieResponse>

    suspend fun getMovie(id: Int): Result<MovieDetailModel>
}

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService
) : MovieDataSource {

    override suspend fun getPopularMovies(): Result<TrendingMovieResponse> {
        return getResult { movieService.getPopularMovies() }
    }

    override suspend fun getMovie(id: Int): Result<MovieDetailModel> {
        return getResult { movieService.getMovie(id) }
    }

}