package com.example.mvvmdemo.repository

import com.example.mvvmdemo.local.db.MovieDao
import com.example.mvvmdemo.local.mapper.MovieLocalMapper
import com.example.mvvmdemo.model.Movie
import com.example.mvvmdemo.model.MovieDetail
import com.example.mvvmdemo.model.Result
import com.example.mvvmdemo.network.MovieDataSource
import com.example.mvvmdemo.network.mapper.MovieRemoteMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

interface MovieRepository {

    fun getPopularMovies(): Flow<Result<List<Movie>>>
    fun getMovie(id: Int): Flow<Result<MovieDetail>>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieLocalSource: MovieDao

) : MovieRepository {
    override fun getPopularMovies(): Flow<Result<List<Movie>>> {
        val movieLocalMapper: MovieLocalMapper = MovieLocalMapper()
        val movieRemoteMapper: MovieRemoteMapper = MovieRemoteMapper()

        val dbFlow = movieLocalSource.getPopularMovies()
            .map { it.map { entity -> movieLocalMapper.toModel(entity) } }
            .map { Result.success(it) }

        val apiFlow = flow {
            val movieResult = movieDataSource.getPopularMovies()

            when (movieResult.status) {
                Result.Status.ERROR -> {
                    emit(Result.error<List<Movie>>(movieResult.message!!, movieResult.errorCode!!))
                }
                Result.Status.SUCCESS -> {
                    movieResult.data?.let {
                        val entities =
                            it.results.map { movieModel -> movieRemoteMapper.fromRemote(movieModel) }
                                .map { movie -> movieLocalMapper.toEntity(movie) }

                        movieLocalSource.insertPopularMovies(entities)
                    }
                }
            }
        }.flowOn(Dispatchers.IO)

        return merge(dbFlow, apiFlow)
            .onStart { emit(Result.loading()) }
    }

    override fun getMovie(id: Int): Flow<Result<MovieDetail>> = flow {

    }

}