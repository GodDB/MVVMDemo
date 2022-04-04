package com.godgod.feature.intent.state

sealed class MovieDetailViewState : ViewState {
    object Idle : MovieDetailViewState()
}