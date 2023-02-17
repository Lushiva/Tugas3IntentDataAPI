package com.bootcamp.tugas3_bootcampidn.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val baseUrl = "https://newsapi.org/v2/top-headlines?country=id&apiKey=f044de69086e45198f8406be2094a229"
    private fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}