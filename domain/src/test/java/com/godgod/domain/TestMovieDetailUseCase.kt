package com.godgod.domain

import com.godgod.domain.fake.FakeMovieRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class TestMovieDetailUseCase {

    private val testDispatcher = TestCoroutineDispatcher()
    lateinit var movieDetailUseCase: MovieDetailUseCase

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
        runBlocking {
            println(movieDetailUseCase.invoke(1))
        }
    }
}


