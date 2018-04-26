package com.test.tosin.stardardresouces.service

import com.test.tosin.stardardresouces.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RemoteRepository {

    fun <S> createService(serviceClass: Class<S>): S {
        val url = "https://raw.githubusercontent.com/TosinRoger/"
        val builder = builderRetrofit(url)
        return builder.build().create(serviceClass)
    }

    private fun builderRetrofit(url: String): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(url)
                .client(builderClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
    }

    private fun builderClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)

        if(BuildConfig.DEBUG)
            httpClient.addInterceptor(logging)

        return httpClient.build()
    }

}