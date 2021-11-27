package com.godgod.data.network.model

import com.google.gson.annotations.SerializedName


data class MovieModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>
)