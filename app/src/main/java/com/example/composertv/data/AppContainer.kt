package com.example.composertv.data

import retrofit2.Retrofit

import com.example.composertv.network.ComposerApiService
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import com.example.composertv.BuildConfig

interface AppContainer {
    val composerRepository: ComposerRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://kinopoiskapiunofficial.tech/"

    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-API-KEY", BuildConfig.API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: ComposerApiService by lazy {
        retrofit.create(ComposerApiService::class.java)
    }

    override val composerRepository: ComposerRepository by lazy {
        DefaultComposerRepository(retrofitService)
    }
}
