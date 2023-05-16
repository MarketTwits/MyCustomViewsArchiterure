package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.content.data.ContentCloudDataSource
import com.example.mycustomviewsarchiterure.content.data.ContentRepository

class BaseContentRepository(
    private val cloudDataSource : ContentCloudDataSource,
    private val handleError: HandleError<Exception, DomainException>): ContentRepository {
    override suspend fun data(): List<NewsDomain> {
       try {
            return cloudDataSource.data().map { it.map() }
       }catch (e : Exception){
            throw  handleError.handle(e)
       }
    }
}