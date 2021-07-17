package com.example.mvvmdemo.base

import android.util.Log
import com.example.mvvmdemo.model.Result
import retrofit2.Response

interface BaseDataSource {

    suspend fun <T> getResult(request: suspend () -> Response<T>): Result<T> {
        return try {
            val response = request.invoke()

            if (response.isSuccessful) {
                Log.d("godgod", "${response.body()}")
                Result.success(response.body())
            } else {
                Log.d("godgod", "${response.message()}")
                Result.error(response.message(), response.code())
            }
        } catch (e: Exception) {
            Log.d("godgod", "${e}")
            Result.error("unknown error", 999)
        }
    }
}