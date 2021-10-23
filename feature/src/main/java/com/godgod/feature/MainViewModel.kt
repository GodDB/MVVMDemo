package com.godgod.feature

import androidx.lifecycle.viewModelScope
import com.godgod.domain.MovieDetailUseCase
import com.godgod.domain.MovieListUseCase
import com.godgod.feature.base.BaseViewModel
import com.godgod.feature.base.ViewEvent
import com.godgod.feature.base.ViewState
import com.godgod.shared.model.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
    private val movieDetailUseCase: MovieDetailUseCase
) : BaseViewModel() {

    override val initialState: () -> ViewState
        get() = { MainViewState() }

    init {
        setEvent(MainViewEvent.LoadMovieList)
    }

    override fun <T> viewStateReduce(prevState: ViewState, partialState: T): ViewState {
        return when (partialState) {
            is MovieListState -> {
                (prevState as MainViewState).copy(movieListState = partialState)
            }
            is MovieDetailState -> {
                (prevState as MainViewState).copy(movieDetailState = partialState)
            }
            else -> throw Exception("not handle state $partialState")
        }
    }

    override fun handleEvent(viewEvent: ViewEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is MainViewEvent.LoadMovieList -> handleMovieList()
                is MainViewEvent.ClickMovieItem -> handleMovieDetail(viewEvent.id)
            }
        }
    }

    private fun handleMovieList() {
        viewModelScope.launch {
            flow { emit(movieListUseCase(Unit)) }
                .onStart { setState(MovieListState.Loading) }
                .collect {
                    when (it) {
                        is DataResult.Success -> {
                            setState(MovieListState.Success(it.data))
                        }
                        is DataResult.Error -> {
                            setState(MovieListState.Idle)
                            setSideEffect(MainViewSideEffect.ErrorMessage(R.string.network_error_msg))
                        }
                    }
                }
        }
    }

    private fun handleMovieDetail(id: Int) {
        viewModelScope.launch {
            flow { emit(movieDetailUseCase(id)) }
                .onStart { setState(MovieDetailState.Loading) }
                .collect {
                    when (it) {
                        is DataResult.Success -> {
                            setState(MovieDetailState.Success(it.data))
                        }
                        is DataResult.Error -> {
                            setState(MovieDetailState.Idle)
                            setSideEffect(MainViewSideEffect.ErrorMessage(R.string.network_error_msg))
                        }
                    }
                }
        }
    }
}
