package com.godgod.feature

import com.godgod.feature.base.ViewState
import com.godgod.shared.model.Movie
import com.godgod.shared.model.MovieDetail

data class MainViewState(
    val movieListState: MovieListState = MovieListState.Idle,
    val movieDetailState: MovieDetailState = MovieDetailState.Idle
) : ViewState


sealed class MovieListState {
    object Loading : MovieListState()
    data class Success(val movies: List<Movie>) : MovieListState()
    object Idle : MovieListState()

    fun getSuccessOrNull() : Success? = (this as? Success)
}

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val detailMovie: MovieDetail) : MovieDetailState()
    object Idle : MovieDetailState()

    fun getSuccessOrNull() : Success? = (this as? Success)
}
