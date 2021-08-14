package com.godgod.data.network

import com.example.mvvmdemo.network.service.MovieService
import com.godgod.data.base.BaseDataSource
import com.godgod.data.network.model.MovieDetailModel
import com.godgod.data.network.model.TrendingMovieResponse
import com.godgod.data.model.Result
import javax.inject.Inject

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