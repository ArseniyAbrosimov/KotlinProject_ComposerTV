package com.example.compositortv.data

import com.example.compositortv.BuildConfig
import com.example.compositortv.network.CompositorApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val compositorRepository: CompositorRepository
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

    private val retrofitService: CompositorApiService by lazy {
        retrofit.create(CompositorApiService::class.java)
    }

    override val compositorRepository: CompositorRepository by lazy {
        DefaultCompositorRepository(retrofitService)
    }
}
