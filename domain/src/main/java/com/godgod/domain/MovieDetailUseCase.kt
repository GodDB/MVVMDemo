package com.godgod.domain

import com.godgod.domain.base.BaseCoroutineUseCase
import com.godgod.domain.repository.MovieRepository
import com.godgod.shared.di.IoDispatcher
import com.godgod.domain.model.MovieDetail
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
    private val movieRepository: MovieRepository
) : BaseCoroutineUseCase<Int, MovieDetail>(coroutineDispatcher) {

    override suspend fun execute(params: Int): MovieDetail {
        return movieRepository.getMovie(params)
    }
}