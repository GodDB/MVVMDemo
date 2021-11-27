package com.godgod.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.godgod.domain.model.GenreSingle

@Entity(tableName = "MovieDetail")
data class MovieDetailEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)