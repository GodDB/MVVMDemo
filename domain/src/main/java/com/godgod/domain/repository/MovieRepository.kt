package com.godgod.domain.repository

import com.godgod.domain.model.Movie
import com.godgod.domain.model.MovieDetail

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovie(id: Int): MovieDetail
}