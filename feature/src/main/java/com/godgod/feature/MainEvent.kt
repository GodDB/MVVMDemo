package com.godgod.feature

import com.godgod.feature.base.ViewEvent


sealed class MainViewEvent : ViewEvent {
    object LoadMovieList : MainViewEvent()
    data class ClickMovieItem(val id: Int) : MainViewEvent()
}