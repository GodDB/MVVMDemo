package com.godgod.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)
