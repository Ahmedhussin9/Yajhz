package com.example.data.api

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(private val sharedPreferences: SharedPreferences):Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sharedPreferences.getString("token","")
        val newRequestBuilder= chain.request().newBuilder()
        token?.let {
            newRequestBuilder.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(newRequestBuilder.build())
    }
}