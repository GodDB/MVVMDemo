package com.godgod.data.network.model

import com.godgod.domain.model.GenreSingle
import com.google.gson.annotations.SerializedName

data class MovieDetailModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("genres")
    val genres: List<GenreSingle>
)
