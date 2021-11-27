package com.godgod.data.network

import com.example.mvvmdemo.network.service.MovieService
import com.godgod.data.base.BaseDataSource
import com.godgod.shared.model.Movie
import com.godgod.data.network.mapper.MovieDetailRemoteMapper
import com.godgod.data.network.mapper.MovieRemoteMapper
import com.godgod.data.network.model.MovieDetailModel
import com.godgod.data.network.model.MovieModel
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

interface MovieDataSource : BaseDataSource {

    suspend fun getPopularMovies(): List<MovieModel>

    suspend fun getMovie(id: Int): MovieDetailModel
}

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService
) : MovieDataSource {

    override suspend fun getPopularMovies(): List<MovieModel> {
        return movieService.getPopularMovies().results
    }

    override suspend fun getMovie(id: Int): MovieDetailModel {
        return movieService.getMovie(id)
    }
}