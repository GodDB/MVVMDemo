package com.godgod.feature.ui.movie_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.godgod.feature.compose.glide.GlideImage
import com.godgod.feature.intent.state.MainViewState
import com.godgod.feature.intent.state.MovieListState
import com.godgod.feature.intent.state.ViewState
import com.godgod.feature.intent.state.isMainViewState
import com.godgod.feature.ui.movie_list.data.MovieViewData


@Composable
fun MovieListScreen(viewModel: MovieListViewModel) {
    val state: ViewState by viewModel.state.collectAsState()
    when (val newState = state) {
        is MainViewState -> {
            MaterialTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    MovieList(state = newState.movieListState)
                }
            }
        }
        else -> {}
    }

}


@Composable
fun MovieList(state: MovieListState) {
    when (state) {
        is MovieListState.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { item ->
                    MovieListItem(data = item)
                }
            }
        }
        else -> {
            //TODO
        }
    }
}

@Composable
fun MovieListItem(data: MovieViewData) {
    Column(
        modifier = Modifier.wrapContentSize()
    ) {
        GlideImage(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            url = data.poster_path
        )

    }
}



