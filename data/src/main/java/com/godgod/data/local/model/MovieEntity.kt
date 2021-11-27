package com.godgod.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PopularMovie")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val overview: String?,
    val popularity: Double,
    val poster_path: String,
    val genre_ids: List<Int>
)