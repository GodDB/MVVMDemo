package com.godgod.data.repository


import com.godgod.data.local.MovieLocalSource
import com.godgod.data.network.MovieDataSource
import com.godgod.shared.extension.getOrDefaultBlock
import com.godgod.shared.model.Movie
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovie(id: Int): MovieDetail
}

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieLocalSource: MovieLocalSource
) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return runCatching {
            movieLocalSource.getPopularMovies()
                .let { if (it.isNullOrEmpty()) throw RuntimeException("isEmpty") else it }
        }.getOrDefaultBlock {
            movieDataSource.getPopularMovies().also {
                movieLocalSource.insertPopularMovies(it)
            }
        }
    }

    override suspend fun getMovie(id: Int): MovieDetail {
        return runCatching {
            movieLocalSource.getMovieDetail(id)
        }.getOrDefaultBlock {
            movieDataSource.getMovie(id).also {
                movieLocalSource.insertMovieDetail(it)
            }
        }
    }

}