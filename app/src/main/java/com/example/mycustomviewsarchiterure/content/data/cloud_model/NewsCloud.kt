package com.example.mycustomviewsarchiterure.content.data.cloud_model

import com.example.mycustomviewsarchiterure.content.domain.NewsDomain

data class NewsCloud(
    private val author: String,
    private val content: String,
    private val date: String,
    private val imageUrl: String,
    private val readMoreUrl: String,
    private val time: String,
    private val title: String,
    private val url: String
){
    fun map() : NewsDomain{
        val isValid = imageUrl.isNotEmpty() && imageUrl.startsWith("http")
        return if (isValid){
            NewsDomain.Base(date, imageUrl, title)
        }else{
            NewsDomain.Invalid
        }
    }
}