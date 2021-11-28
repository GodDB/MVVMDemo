package com.godgod.domain

import com.godgod.domain.fake.FakeMovieRepositoryImpl
import com.godgod.domain.model.MovieDetail
import com.godgod.shared.model.data
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@ExperimentalCoroutinesApi
class TestMovieDetailUseCase {

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var movieDetailUseCase: MovieDetailUseCase

    @Before
    fun setup() {
        movieDetailUseCase = MovieDetailUseCase(
            testDispatcher,
            FakeMovieRepositoryImpl()
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `영화 디테일 정보 가져오기`() {
        runBlockingTest {
            //given
            val params = 1

            //when
            val movieDetail = movieDetailUseCase.invoke(params)

            //then
            movieDetail.data?.let {
                assertEquals<MovieDetail>(MovieDetail.getDefault(), it)
            }
        }
    }
}


