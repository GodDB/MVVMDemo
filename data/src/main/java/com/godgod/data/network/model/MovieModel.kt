package com.godgod.data.network.model


data class MovieModel(
    val id: Int,
    val title: String?,
    val overview: String?,
    val popularity: Double,
    val poster_path: String,
    val genre_ids: List<Int>
)