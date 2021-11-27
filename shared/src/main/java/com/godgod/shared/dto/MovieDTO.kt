package com.godgod.shared.dto

abstract class MovieDTO(
    open val id : Int,
    open val title : String?,
    open val overview : String?,
    open val popularity : Double,
    open val poster_path : String,
    open val genre_ids : List<Int>
)