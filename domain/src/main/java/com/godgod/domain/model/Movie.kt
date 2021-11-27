package com.godgod.domain.model

data class Movie(
    val id: Int,
    val title: String?,
    val overview: String?,
    val popularity: Double,
    val poster_path: String,
    val genre_ids: List<Int>
) {
    companion object {
        fun getDefault() : Movie {
            return Movie(3, "", "", 0.0, "", listOf(1,2,3))
        }
    }
}