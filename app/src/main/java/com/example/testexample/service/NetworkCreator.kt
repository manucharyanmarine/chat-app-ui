package com.example.testexample.service

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkCreator @Inject constructor() {
    fun provideChatApi(): ChatApi {
        val interceptor = Interceptor { chain ->
            val request = chain.request()

            val newUrl = request.url.newBuilder()
                .host("http://192.168.101.8")
                .port(3001)
                .build()

            val updatedRequest = request.newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(updatedRequest)
        }

        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(logging)
            .build()

        val instance: ChatApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(ChatApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ChatApi::class.java)
        }

        return instance
    }
}