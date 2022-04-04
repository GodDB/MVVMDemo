package com.godgod.feature.ui.movie_list.data

import com.godgod.domain.model.Movie

data class MovieViewData(
    val id: Int,
    val title: String?,
    val overview: String?,
    val popularity: Double,
    val poster_path: String,
    val genre_ids: List<Int>,
    val isSelect: Boolean
)

fun List<Movie>.toViewList() : List<MovieViewData> {
    return this.map { it.toViewData() }
}

fun Movie.toViewData(
    id: Int = this.id,
    title: String? = this.title,
    overview: String? = this.overview,
    popularity: Double = this.popularity,
    poster_path: String = this.poster_path,
    genre_ids: List<Int> = this.genre_ids,
    isSelect: Boolean = false
): MovieViewData =
    MovieViewData(id, title, overview, popularity, poster_path, genre_ids, isSelect)