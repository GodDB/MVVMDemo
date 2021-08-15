package com.godgod.data.network.model

import com.godgod.shared.model.GenreSingle

data class MovieDetailModel(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)
