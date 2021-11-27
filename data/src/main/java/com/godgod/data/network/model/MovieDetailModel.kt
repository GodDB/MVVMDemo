package com.godgod.data.network.model

import com.godgod.shared.dto.MovieDetailDTO
import com.godgod.shared.model.GenreSingle
import com.google.gson.annotations.SerializedName

data class MovieDetailModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    override val title: String,
    @SerializedName("overview")
    override val overview: String,
    @SerializedName("poster_path")
    override val poster_path: String,
    @SerializedName("genres")
    override val genres: List<GenreSingle>
) : MovieDetailDTO(id, title, overview, poster_path, genres)
