package com.godgod.domain

import com.godgod.domain.base.BaseCoroutineUseCase
import com.godgod.domain.repository.MovieRepository
import com.godgod.shared.di.IoDispatcher
import com.godgod.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MovieListUseCase @Inject constructor(
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val movieRepository: MovieRepository
) : BaseCoroutineUseCase<Any, List<Movie>>(coroutineDispatcher) {

    override suspend fun execute(params: Any): List<Movie> {
        return movieRepository.getPopularMovies()
    }
}