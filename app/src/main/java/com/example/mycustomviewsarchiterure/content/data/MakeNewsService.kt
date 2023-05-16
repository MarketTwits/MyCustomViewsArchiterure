package com.example.mycustomviewsarchiterure.content.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface MakeNewsService {
    fun service(): NewsService
    class Base(
        private val url : String = "https://inshorts.deta.dev/"
    ) : MakeNewsService {
        override fun service() =
            Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
    }
}