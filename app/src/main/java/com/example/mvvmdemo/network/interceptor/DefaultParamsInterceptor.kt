package com.example.mvvmdemo.network.interceptor

import com.example.mvvmdemo.BuildConfig
import com.example.mvvmdemo.Config
import okhttp3.Interceptor
import okhttp3.Response

class DefaultParamsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newHttpUrl = original.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val newRequestBuilder = original.newBuilder()
            .url(newHttpUrl)

        return chain.proceed(newRequestBuilder.build())
    }


}