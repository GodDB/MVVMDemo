package com.godgod.data.local

import com.godgod.data.local.db.MovieDao
import com.godgod.data.local.mapper.MovieDetailMapper
import com.godgod.data.local.mapper.MovieLocalMapper
import com.godgod.shared.model.Movie
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

interface MovieLocalSource {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun insertPopularMovies(movies: List<Movie>)

    suspend fun getMovieDetail(id : Int) : MovieDetail
    suspend fun insertMovieDetail(movieDetail : MovieDetail)
}

class MovieLocalSourceImpl @Inject constructor(
    private val movieLocalMapper: MovieLocalMapper,
    private val movieDetailLocalMapper : MovieDetailMapper,
    private val movieDao: MovieDao
) : MovieLocalSource {

    override suspend fun getPopularMovies(): List<Movie> {
        return movieDao.getPopularMovies().map { movieLocalMapper.toModel(it) }
    }

    override suspend fun insertPopularMovies(movies: List<Movie>) {
        movieDao.insertPopularMovies(movies.map { movieLocalMapper.toEntity(it) })
    }

    override suspend fun getMovieDetail(id: Int): MovieDetail {
        return movieDetailLocalMapper.toModel(movieDao.getMovieDetail(id))
    }

    override suspend fun insertMovieDetail(movieDetail: MovieDetail) {
        movieDao.insertMovieDetail(
            movieDetailLocalMapper.toEntity(movieDetail)
        )
    }


}