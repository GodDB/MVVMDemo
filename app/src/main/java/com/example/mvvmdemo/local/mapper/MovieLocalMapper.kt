package com.example.mvvmdemo.local.mapper

import com.example.mvvmdemo.base.BaseLocalMapper
import com.example.mvvmdemo.local.model.MovieEntity
import com.example.mvvmdemo.model.Movie

class MovieLocalMapper : BaseLocalMapper<Movie, MovieEntity> {

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
