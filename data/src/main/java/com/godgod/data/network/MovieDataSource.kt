package com.godgod.data.network

import com.example.mvvmdemo.network.service.MovieService
import com.godgod.data.base.BaseDataSource
import com.godgod.shared.model.Movie
import com.godgod.data.network.mapper.MovieDetailRemoteMapper
import com.godgod.data.network.mapper.MovieRemoteMapper
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

interface MovieDataSource : BaseDataSource {

    suspend fun getPopularMovies(): List<Movie>

    suspend fun getMovie(id: Int): MovieDetail
}

class MovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieRemoteMapper: MovieRemoteMapper,
    private val movieDetailRemoteMapper: MovieDetailRemoteMapper
) : MovieDataSource {

    override suspend fun getPopularMovies(): List<Movie> {
        return movieService.getPopularMovies().results.map { movieRemoteMapper.fromRemote(it) }
    }

    override suspend fun getMovie(id: Int): MovieDetail {
        return movieDetailRemoteMapper.fromRemote(movieService.getMovie(id))
    }

}