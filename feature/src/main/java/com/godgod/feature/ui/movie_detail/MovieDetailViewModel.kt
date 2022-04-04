package com.godgod.feature.ui.movie_detail

import com.godgod.feature.base.BaseViewModel
import com.godgod.feature.intent.event.ViewEvent
import com.godgod.feature.intent.state.MovieDetailState
import com.godgod.feature.intent.state.MovieDetailViewState
import com.godgod.feature.intent.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor() : BaseViewModel() {

    override val initialState: () -> ViewState
        get() = { MovieDetailViewState.Idle }

    override suspend fun handleEvent(viewEvent: ViewEvent) {
        TODO("Not yet implemented")
    }

    override fun <T> viewStateUpdate(prevState: ViewState, partialState: T): ViewState {
        TODO("Not yet implemented")
    }
}