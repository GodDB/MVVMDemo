package com.godgod.data.network.mapper

import com.godgod.data.network.model.MovieDetailModel
import com.godgod.data.network.model.MovieModel
import com.godgod.data.base.BaseRemoteMapper
import com.godgod.data.model.Movie
import com.godgod.data.model.MovieDetail

class MovieRemoteMapper : BaseRemoteMapper<MovieModel, Movie> {
    override fun fromRemote(remote: MovieModel): Movie =
        with(remote) {
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

class MovieDetailRemoteMapper : BaseRemoteMapper<MovieDetailModel, MovieDetail> {
    override fun fromRemote(remote: MovieDetailModel): MovieDetail =
        with(remote) {
            MovieDetail(
                id, title, overview, poster_path, genres
            )
        }
}