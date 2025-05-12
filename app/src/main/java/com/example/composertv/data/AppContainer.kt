package com.example.composertv.data

import retrofit2.Retrofit

import com.example.composertv.network.ConverterApiService
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val amphibiansRepository: ComposerRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://kinopoiskapiunofficial.tech/"

    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-API-KEY", "...")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ConverterApiService by lazy {
        retrofit.create(ConverterApiService::class.java)
    }

    override val amphibiansRepository: ComposerRepository by lazy {
        DefaultComposerRepository(retrofitService)
    }
}
