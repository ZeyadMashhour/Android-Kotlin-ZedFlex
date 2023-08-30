package com.example.zedflex.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object RetrofitInstance {
    private const val BASE_URL = "https://imdb8.p.rapidapi.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-RapidAPI-Key", "05be22d53cmsh779616cb0855fffp190db6jsn04f46c22d0b6")
                .addHeader("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }
        .build()

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
