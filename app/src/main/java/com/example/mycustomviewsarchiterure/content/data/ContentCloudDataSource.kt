package com.example.mycustomviewsarchiterure.content.data

import com.example.mycustomviewsarchiterure.content.data.cloud_model.NewsCloud

interface ContentCloudDataSource {
    suspend fun data() : List<NewsCloud>
    class Base(
        private val service : NewsService
    ) : ContentCloudDataSource{
        override suspend fun data(): List<NewsCloud> {
            return service.data().data
        }
    }
}