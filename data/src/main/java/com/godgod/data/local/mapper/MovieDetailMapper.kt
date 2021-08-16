package com.godgod.data.local.mapper

import com.godgod.data.base.BaseLocalMapper
import com.godgod.data.local.model.MovieDetailEntity
import com.godgod.shared.model.MovieDetail
import javax.inject.Inject

class MovieDetailMapper @Inject constructor() : BaseLocalMapper<MovieDetail, MovieDetailEntity> {
    override fun toEntity(model: MovieDetail): MovieDetailEntity {
        return with(model) {
            MovieDetailEntity(id, title, overview, poster_path, genres)
        }
    }

    override fun toModel(entity: MovieDetailEntity): MovieDetail {
        return with(entity) {
            MovieDetail(id, title, overview, poster_path, genres)
        }
    }
}