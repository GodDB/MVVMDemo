package com.godgod.feature

import androidx.annotation.StringRes
import com.godgod.feature.base.ViewSideEffect

sealed class MainViewSideEffect : ViewSideEffect {
    data class ErrorMessage(@StringRes val errorMessage: Int) : MainViewSideEffect()
}