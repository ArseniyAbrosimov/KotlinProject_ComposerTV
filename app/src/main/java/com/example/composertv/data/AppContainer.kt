package com.example.composertv.data

import com.example.composertv.BuildConfig
import com.example.composertv.network.ComposerApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val composerRepository: ComposerRepository
}

class DefaultAppContainer : AppContainer {
    private val baseURL = "https://kinopoiskapiunofficial.tech/"

    val httpClient =
        OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val request =
                    chain
                        .request()
                        .newBuilder()
                        .addHeader("X-API-KEY", BuildConfig.API_KEY)
                        .build()
                chain.proceed(request)
            }.build()

    private val retrofit: Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseURL)
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
