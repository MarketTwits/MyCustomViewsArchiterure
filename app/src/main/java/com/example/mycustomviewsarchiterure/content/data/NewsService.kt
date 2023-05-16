package com.example.mycustomviewsarchiterure.content.data

import com.example.mycustomviewsarchiterure.content.data.cloud_model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("news")
    suspend fun data(
        @Query("category") category: String = "technology"
    ): NewsResponse
}