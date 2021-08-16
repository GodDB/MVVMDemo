package com.godgod.domain

import com.godgod.shared.model.Movie
import com.godgod.data.repository.MovieRepository
import com.godgod.domain.base.BaseCoroutineUseCase
import com.godgod.shared.di.IoDispatcher
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