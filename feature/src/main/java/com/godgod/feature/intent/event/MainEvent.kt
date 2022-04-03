package com.godgod.feature.intent.event

sealed class MainViewEvent : ViewEvent {
    object LoadMovieList : MainViewEvent()
    data class ClickMovieItem(val id: Int) : MainViewEvent()
}