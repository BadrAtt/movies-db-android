package com.elattaoui.badr.moviesdb.data.di

import com.elattaoui.badr.moviesdb.data.Api
import com.elattaoui.badr.moviesdb.data.interceptor.DefaultQueryParamsInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.moczul.ok2curl.CurlInterceptor
import com.moczul.ok2curl.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Singleton
    @Provides
    fun providesOkHttp(
        defaultQueryParamsInterceptor: DefaultQueryParamsInterceptor
    ): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(defaultQueryParamsInterceptor)
            .addInterceptor(CurlInterceptor(object : Logger {
                override fun log(message: String) {
                    Timber.v("Ok2Curl", message)
                }
            }))
            .build()

    }

    @Singleton
    @Provides
    fun provideJsonSerializer(): Json {
        return Json {
            ignoreUnknownKeys = true
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun providesApi(httpClient: OkHttpClient, jsonSerializer: Json): Api {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(jsonSerializer.asConverterFactory(contentType))
            .client(httpClient)
            .build()
            .create(Api::class.java)
    }
}
