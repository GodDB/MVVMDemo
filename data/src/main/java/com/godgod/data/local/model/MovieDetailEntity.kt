package com.godgod.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.godgod.shared.dto.MovieDetailDTO
import com.godgod.shared.model.GenreSingle

@Entity(tableName = "MovieDetail")
data class MovieDetailEntity(
    @PrimaryKey
    override val id: Int,
    override val title: String,
    override val overview: String,
    override val poster_path: String,
    override val genres: List<GenreSingle>
) : MovieDetailDTO(id, title, overview, poster_path, genres)