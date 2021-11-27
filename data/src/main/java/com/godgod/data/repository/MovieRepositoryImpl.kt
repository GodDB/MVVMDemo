package com.godgod.data.repository


import com.godgod.data.local.MovieLocalSource
import com.godgod.data.local.mapper.MovieDetailMapper
import com.godgod.data.local.mapper.MovieLocalMapper
import com.godgod.data.network.MovieDataSource
import com.godgod.data.network.mapper.MovieDetailRemoteMapper
import com.godgod.data.network.mapper.MovieRemoteMapper
import com.godgod.domain.repository.MovieRepository
import com.godgod.shared.extension.getOrDefaultBlock
import com.godgod.domain.model.Movie
import com.godgod.domain.model.MovieDetail
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieLocalSource: MovieLocalSource,
    private val movieDetailRemoteMapper: MovieDetailRemoteMapper,
    private val movieLocalMapper: MovieLocalMapper,
    private val movieDetailLocalMapper: MovieDetailMapper,
    private val movieRemoteMapper: MovieRemoteMapper
) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return runCatching {
            movieLocalSource.getPopularMovies()
                .let { if (it.isNullOrEmpty()) throw RuntimeException("isEmpty") else it }
                .map { movieLocalMapper.toModel(it) }
        }.getOrDefaultBlock {
            movieDataSource.getPopularMovies()
                .map { movieRemoteMapper.fromRemote(it) }
                .also {
                    movieLocalSource.insertPopularMovies(it.map { movieLocalMapper.toEntity(it) })
                }
        }
    }

    override suspend fun getMovie(id: Int): MovieDetail {
        return runCatching {
            movieDetailLocalMapper.toModel(movieLocalSource.getMovieDetail(id))
        }.getOrDefaultBlock {
            movieDetailRemoteMapper.fromRemote(movieDataSource.getMovie(id))
                .also {
                    movieLocalSource.insertMovieDetail(movieDetailLocalMapper.toEntity(it))
                }
        }
    }

}