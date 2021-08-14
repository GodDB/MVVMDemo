package com.godgod.data.model

import com.godgod.data.network.model.GenreSingle

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)
