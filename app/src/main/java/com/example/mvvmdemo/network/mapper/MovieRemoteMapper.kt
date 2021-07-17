package com.example.mvvmdemo.network.mapper

import com.example.mvvmdemo.base.BaseRemoteMapper
import com.example.mvvmdemo.model.Movie
import com.example.mvvmdemo.model.MovieDetail
import com.example.mvvmdemo.network.model.MovieDetailModel
import com.example.mvvmdemo.network.model.MovieModel

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