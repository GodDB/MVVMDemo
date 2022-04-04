package com.godgod.feature.intent.sideEffect

import androidx.annotation.StringRes

sealed class MainViewSideEffect : ViewSideEffect {
    data class ErrorMessage(@StringRes val errorMessage: Int) : MainViewSideEffect()
    data class NavigateToMovieDetail(val movieId : Int) : MainViewSideEffect()
}