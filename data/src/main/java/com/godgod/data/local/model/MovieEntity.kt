package com.godgod.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.godgod.shared.dto.MovieDTO

@Entity(tableName = "PopularMovie")
data class MovieEntity(
    @PrimaryKey
    override val id: Int,
    override val title: String?,
    override val overview: String?,
    override val popularity: Double,
    override val poster_path: String,
    override val genre_ids: List<Int>
) : MovieDTO(id, title, overview, popularity, poster_path, genre_ids)