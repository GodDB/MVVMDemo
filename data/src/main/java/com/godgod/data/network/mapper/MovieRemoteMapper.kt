package com.godgod.data.network.mapper

import com.godgod.data.network.model.MovieDetailModel
import com.godgod.data.network.model.MovieModel
import com.godgod.data.base.BaseRemoteMapper
import com.godgod.domain.model.Movie
import com.godgod.domain.model.MovieDetail
import javax.inject.Inject

class MovieRemoteMapper @Inject constructor(): BaseRemoteMapper<MovieModel, Movie> {
    override fun fromRemote(model: MovieModel): Movie =
        with(model) {
            Movie(
                id = id,
                title = title,
                overview = overview,
                popularity = popularity,
                poster_path = "https://image.tmdb.org/t/p/original$poster_path",
                genre_ids = genre_ids
            )
        }
}

class MovieDetailRemoteMapper @Inject constructor() : BaseRemoteMapper<MovieDetailModel, MovieDetail> {
    override fun fromRemote(model: MovieDetailModel): MovieDetail =
        with(model) {
            MovieDetail(
                id, title, overview, "https://image.tmdb.org/t/p/original$poster_path", genres
            )
        }
}