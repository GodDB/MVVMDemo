package com.godgod.shared.model


/**
 * A generic class that holds a value
 * @param <T>
 */
sealed class DataResult<out R> {

    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val exception: Throwable) : DataResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

val DataResult<*>.succeeded
    get() = this is DataResult.Success && data != null

fun <T> DataResult<T>.successOr(fallback: T): T {
    return (this as? DataResult.Success<T>)?.data ?: fallback
}

val <T> DataResult<T>.data: T?
    get() = (this as? DataResult.Success)?.data

