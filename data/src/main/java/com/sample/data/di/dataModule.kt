package com.sample.data.di

import com.sample.data.BuildConfig
import com.sample.data.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {
    single {
        get<Retrofit>(named(DATA_RETROFIT)).create(ApiService::class.java) as ApiService
    }

    single(named(DATA_INTERCEPTOR)) {
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.BASIC
                }
        }
    }


    single<OkHttpClient>(named(WITH_AUTH)) {
        OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>(named(DATA_INTERCEPTOR)))
            .build()
    }

    single<Retrofit>(named(DATA_RETROFIT)) {
        Retrofit.Builder()
            .client(get(named(WITH_AUTH)))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

}

private const val BASE_URL = "https://api.github.com/"
const val WITH_AUTH = "withAuth"
const val DATA_RETROFIT = "data_retrofit"
const val DATA_INTERCEPTOR = "data_interceptor"