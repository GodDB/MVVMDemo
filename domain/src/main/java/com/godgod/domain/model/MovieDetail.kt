package com.godgod.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
) : Parcelable {
    companion object {
        fun getDefault() : MovieDetail {
            return MovieDetail(3, "", "", "", listOf(GenreSingle.getDefault()))
        }
    }
}
