package com.godgod.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenreSingle(val id: Int, val name: String) : Parcelable {
    companion object {
        fun getDefault(): GenreSingle {
            return GenreSingle(1, "god")
        }
    }
}