package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.content.content.NewsUi

interface NewsUiMapper {
    fun map(title: String, imageUrl: String) : NewsUi
    class Base(
      private val loadingModeCache: LoadingModeCache.Read
    ) : NewsUiMapper{
        override fun map(title: String, imageUrl: String): NewsUi =
            NewsUi.Base(!loadingModeCache.isWifiOnly(),title, imageUrl, )
    }
}