package com.godgod.domain.model

data class GenreSingle(val id: Int, val name: String) {
    companion object {
        fun getDefault(): GenreSingle {
            return GenreSingle(1, "god")
        }
    }
}