package com.example.basic_application.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig(private val baseURl: String = "https://jsonplaceholder.typicode.com/") {
    private var instance: Retrofit? = null

    fun retrofit(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(baseURl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return instance!!
    }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().apply {
                    header("Authorization", "")
                }.build()
                chain.proceed(request)
            }
            .build()
}