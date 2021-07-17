package com.example.mvvmdemo.model

import com.example.mvvmdemo.network.model.GenreSingle

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)
