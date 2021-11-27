package com.godgod.domain

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.Module
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.testing.TestInstallIn
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TestMovieDetailUseCase {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var movieDetailUseCase: MovieDetailUseCase

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun `영화 디테일 정보 가져오기`() {


        movieDetailUseCase.invoke()
    }
}


