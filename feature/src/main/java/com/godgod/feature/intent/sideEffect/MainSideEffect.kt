package com.godgod.feature.intent.sideEffect

import androidx.annotation.StringRes
import com.godgod.domain.model.MovieDetail

sealed class MainViewSideEffect : ViewSideEffect {
    data class ErrorMessage(@StringRes val errorMessage: Int) : MainViewSideEffect()
    data class NavigateToMovieDetail(val movieDetail : MovieDetail) : MainViewSideEffect()
}