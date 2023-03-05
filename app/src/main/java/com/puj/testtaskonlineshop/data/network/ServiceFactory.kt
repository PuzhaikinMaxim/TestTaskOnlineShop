package com.puj.testtaskonlineshop.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceFactory {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    fun<T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}