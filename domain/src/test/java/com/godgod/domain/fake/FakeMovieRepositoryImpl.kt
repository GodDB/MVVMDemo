package com.godgod.domain.fake

import com.godgod.domain.model.Movie
import com.godgod.domain.model.MovieDetail
import com.godgod.domain.repository.MovieRepository
import javax.inject.Inject

class FakeMovieRepositoryImpl : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return listOf(Movie.getDefault())
    }

    override suspend fun getMovie(id: Int): MovieDetail {
        return MovieDetail.getDefault()
    }
}