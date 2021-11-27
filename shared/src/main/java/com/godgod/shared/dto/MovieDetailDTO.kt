package com.godgod.shared.dto

import com.godgod.shared.model.GenreSingle

abstract class MovieDetailDTO(
    open val id : Int,
    open val title : String,
    open val overview : String,
    open val poster_path : String,
    open val genres : List<GenreSingle>
)