package com.godgod.data.network.model

import com.godgod.shared.dto.MovieDTO
import com.google.gson.annotations.SerializedName


data class MovieModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    override val title: String?,
    @SerializedName("overview")
    override val overview: String?,
    @SerializedName("popularity")
    override val popularity: Double,
    @SerializedName("poster_path")
    override val poster_path: String,
    @SerializedName("genre_ids")
    override val genre_ids: List<Int>
) : MovieDTO(id, title, overview, popularity, poster_path, genre_ids)