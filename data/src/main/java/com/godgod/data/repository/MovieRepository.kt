package com.godgod.data.repository


import com.example.mvvmdemo.extension.getOrDefaultBlock
import com.godgod.data.local.MovieLocalSource
import com.godgod.data.model.Movie
import com.godgod.data.network.MovieDataSource
import com.godgod.shared.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>
    fun getMovie(id: Int): Flow<MovieDetail>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieLocalSource: MovieLocalSource

) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return runCatching {
            movieLocalSource.getPopularMovies()
        }.getOrDefaultBlock {
            val movies = movieDataSource.getPopularMovies()
            movieLocalSource.insertPopularMovies(movies)
            movies
        }
    }


    override fun getMovie(id: Int): Flow<MovieDetail> = flow {

    }

}