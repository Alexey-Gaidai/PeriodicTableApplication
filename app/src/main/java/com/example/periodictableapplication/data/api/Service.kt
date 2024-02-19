package com.example.periodictableapplication.data.api

import com.example.periodictableapplication.data.api.model.PeriodicTable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://raw.githubusercontent.com/"

interface Service {
    companion object {
        private val logger: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val okHttp =
            OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

        fun createApiService(): Service {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp)
                .build()
            return retrofit.create(Service::class.java)
        }
    }

    @GET("/Alexey-Gaidai/saadasdasd/main/russian.json")
    suspend fun getTableElements(): Response<PeriodicTable>
}