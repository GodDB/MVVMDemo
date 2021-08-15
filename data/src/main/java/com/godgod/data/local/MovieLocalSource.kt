package com.godgod.data.local

import com.godgod.data.local.db.MovieDao
import com.godgod.data.local.mapper.MovieLocalMapper
import com.godgod.data.model.Movie
import javax.inject.Inject

interface MovieLocalSource {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun insertPopularMovies(movies: List<Movie>)
}

class MovieLocalSourceImpl @Inject constructor(
    private val localMapper: MovieLocalMapper,
    private val movieDao: MovieDao
) : MovieLocalSource {

    override suspend fun getPopularMovies(): List<Movie> {
        return movieDao.getPopularMovies().map { localMapper.toModel(it) }
    }

    override suspend fun insertPopularMovies(movies: List<Movie>) {
        movieDao.insertPopularMovies(movies.map { localMapper.toEntity(it) })
    }


}