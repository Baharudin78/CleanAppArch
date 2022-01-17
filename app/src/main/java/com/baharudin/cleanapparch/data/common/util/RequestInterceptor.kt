package com.baharudin.cleanapparch.data.common.util

import com.baharudin.cleanapparch.infrastructure.utils.SharedPrefs
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor constructor(
    private val sharedPrefs: SharedPrefs
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPrefs.getToken()
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}