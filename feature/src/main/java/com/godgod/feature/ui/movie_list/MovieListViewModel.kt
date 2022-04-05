package com.godgod.feature.ui.movie_list

import com.godgod.domain.MovieDetailUseCase
import com.godgod.domain.MovieListUseCase
import com.godgod.domain.model.MovieDetail
import com.godgod.feature.R
import com.godgod.feature.base.BaseViewModel
import com.godgod.feature.intent.event.MainViewEvent
import com.godgod.feature.intent.event.ViewEvent
import com.godgod.feature.intent.sideEffect.MainViewSideEffect
import com.godgod.feature.intent.state.MainViewState
import com.godgod.feature.intent.state.MovieDetailState
import com.godgod.feature.intent.state.MovieListState
import com.godgod.feature.intent.state.ViewState
import com.godgod.feature.ui.movie_list.data.MovieViewData
import com.godgod.feature.ui.movie_list.data.toViewList
import com.godgod.shared.model.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
    private val movieDetailUseCase: MovieDetailUseCase
) : BaseViewModel() {

    override val initialState: () -> ViewState
        get() = { MainViewState() }

    val onClickMovieItem: (MovieViewData) -> Unit = { movie ->
        setEvent(MainViewEvent.ClickMovieItem(movie.id))
    }

    val onClickMovieDetail: (MovieDetail) -> Unit = { movieDetail ->
        setSideEffect(MainViewSideEffect.NavigateToMovieDetail(movieDetail))
    }

    init {
        setEvent(MainViewEvent.LoadMovieList)
    }

    override suspend fun handleEvent(viewEvent: ViewEvent) {
        when (viewEvent) {
            is MainViewEvent.LoadMovieList -> handleMovieList()
            is MainViewEvent.ClickMovieItem -> handleMovieDetail(viewEvent.id)
        }
    }

    override fun <T> viewStateUpdate(prevState: ViewState, partialState: T): ViewState {
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

    private suspend fun handleMovieList() {
        flow { emit(movieListUseCase(Unit)) }
            .onStart { setState(MovieListState.Loading) }
            .catch {
                setState(MovieListState.Idle)
                setSideEffect(MainViewSideEffect.ErrorMessage(R.string.network_error_msg))
            }.onEach {
                when (it) {
                    is DataResult.Success -> {
                        setState(MovieListState.Success(it.data.toViewList()))
                        handleMovieDetail(it.data.first().id)
                    }
                    is DataResult.Error -> {
                        setState(MovieListState.Idle)
                        setSideEffect(MainViewSideEffect.ErrorMessage(R.string.network_error_msg))
                    }
                }
            }.collect()
    }

    private suspend fun handleMovieDetail(id: Int) {
        flow { emit(movieDetailUseCase(id)) }
            .onStart {
                setState(MovieDetailState.Loading)
                setState(getSelectedMovieState(id))
            }
            .catch {
                setState(MovieDetailState.Idle)
                setSideEffect(MainViewSideEffect.ErrorMessage(R.string.network_error_msg))
            }
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

    private fun getSelectedMovieState(id: Int): MovieListState {
        return (state.value as MainViewState).movieListState.getSuccessOrThrow().movies.map {
            if (it.id == id) it.copy(isSelect = true) else it.copy(isSelect = false)
        }.let {
            MovieListState.Success(it)
        }
    }

}
