package com.godgod.data.local

import com.godgod.data.local.db.MovieDao
import com.godgod.data.local.mapper.MovieDetailMapper
import com.godgod.data.local.mapper.MovieLocalMapper
import com.godgod.data.local.model.MovieDetailEntity
import com.godgod.data.local.model.MovieEntity
import com.godgod.shared.model.Movie
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

interface MovieLocalSource {

    suspend fun getPopularMovies(): List<MovieEntity>
    suspend fun insertPopularMovies(movies: List<MovieEntity>)

    suspend fun getMovieDetail(id : Int) : MovieDetailEntity
    suspend fun insertMovieDetail(movieDetail : MovieDetailEntity)
}

class MovieLocalSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalSource {

    override suspend fun getPopularMovies(): List<MovieEntity> {
        return movieDao.getPopularMovies()
    }

    override suspend fun insertPopularMovies(movies: List<MovieEntity>) {
        movieDao.insertPopularMovies(movies)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailEntity {
        return movieDao.getMovieDetail(id)
    }

    override suspend fun insertMovieDetail(movieDetail: MovieDetailEntity) {
        movieDao.insertMovieDetail(movieDetail)
    }


}