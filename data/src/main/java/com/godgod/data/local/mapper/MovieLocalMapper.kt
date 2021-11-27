package com.godgod.data.local.mapper

import com.godgod.data.base.BaseLocalMapper
import com.godgod.data.local.model.MovieEntity
import com.godgod.domain.model.Movie
import javax.inject.Inject

class MovieLocalMapper @Inject constructor() : BaseLocalMapper<Movie, MovieEntity> {

    override fun toEntity(model: Movie): MovieEntity =
        with(model) {
            MovieEntity(
                id = id,
                title = title,
                overview = overview,
                popularity = popularity,
                poster_path = poster_path,
                genre_ids = genre_ids
            )
        }


    override fun toModel(entity: MovieEntity): Movie =
        with(entity) {
            Movie(
                id = id,
                title = title,
                overview = overview,
                popularity = popularity,
                poster_path = poster_path,
                genre_ids = genre_ids
            )
        }
}
