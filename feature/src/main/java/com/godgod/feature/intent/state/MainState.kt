package com.godgod.feature.intent.state

import com.godgod.domain.model.Movie
import com.godgod.domain.model.MovieDetail
import com.godgod.feature.ui.movie_list.data.MovieViewData
import kotlin.jvm.Throws

data class MainViewState(
    val movieListState: MovieListState = MovieListState.Idle,
    val movieDetailState: MovieDetailState = MovieDetailState.Idle
) : ViewState


sealed class MovieListState {
    object Loading : MovieListState()
    data class Success(val movies: List<MovieViewData>) : MovieListState()
    object Idle : MovieListState()

    fun getSuccessOrNull(): Success? = (this as? Success)

    @Throws
    fun getSuccessOrThrow() : Success {
        check(this is Success) { "MovieListState != Success" }
        return this
    }
}

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val detailMovie: MovieDetail) : MovieDetailState()
    object Idle : MovieDetailState()

    fun getSuccessOrNull(): Success? = (this as? Success)
}
