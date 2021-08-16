package com.godgod.data.local

import androidx.room.TypeConverter
import com.godgod.shared.model.GenreSingle

/**
 * converts List to and from String
 */
class GenreConverters {

    @TypeConverter
    fun genreSingleListToString(values : List<GenreSingle>) : String {
        return values.joinToString(",") {
            "${it.id}-${it.name}"
        }
    }

    @TypeConverter
    fun stringToGenreSingleList(values : String) : List<GenreSingle> {
        return values.split(",").map {
            val value = it.split("-")
            GenreSingle(value[0].toInt(), value[1])
        }
    }


    @TypeConverter
    fun listToString(values: List<Int>): String {
        val strList = mutableListOf<String>()
        values.forEach {
            strList.add(it.toString())
        }
        return strList.joinToString(",")
    }

    @TypeConverter
    fun stringToList(value: String): List<Int> {
        val intList = mutableListOf<Int>()
        value.split(",").forEach {
            intList.add(it.toInt())
        }
        return intList
    }

}