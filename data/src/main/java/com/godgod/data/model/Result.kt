package com.godgod.data.model

/**
 * Generic class for holding success response, error response and loading status
 */
data class Result<out T>(val status: Status, val data: T?, val errorCode: Int?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, errorCode: Int): Result<T> {
            return Result(Status.ERROR, null, errorCode, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "com.godgod.data.model.Result(status=$status, data=$data, errorCode=$errorCode, message=$message)"
    }
}