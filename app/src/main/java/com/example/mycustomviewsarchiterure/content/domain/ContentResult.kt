package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.content.content.ContentCommunication
import com.example.mycustomviewsarchiterure.content.content.ContentUiState
import com.example.mycustomviewsarchiterure.content.content.NewsUi

interface ContentResult {
    fun map(communication: ContentCommunication)
    class Success(private val news : List<NewsUi>) : ContentResult{
        override fun map(communication: ContentCommunication) {
            communication.map(ContentUiState.Success(news))
        }
    }
    class Error(private val message : String) : ContentResult{
        override fun map(communication: ContentCommunication) {
            communication.map(ContentUiState.Error(message))
        }
    }
}