package com.godgod.feature.ui.movie_list

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MovieListScreen() {
    MaterialTheme {
        
    }
}

@Composable
fun MovieListItem() {
    Row {
       Text(text = "godgod") 
    }
}


@Preview(name = "MovieListPreview")
@Composable
fun MovieListPreview() {
    MovieListScreen()
}

@Preview(name = "MovieListItem")
@Composable
fun MovieListItemPreview() {
    MovieListItem()
}