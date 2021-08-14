package com.godgod.data.network.model

data class MovieDetailModel(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)

data class GenreSingle(val id: Int, val name: String)