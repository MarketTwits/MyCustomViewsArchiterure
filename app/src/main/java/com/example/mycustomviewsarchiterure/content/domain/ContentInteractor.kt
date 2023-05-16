package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.content.data.ContentRepository

interface ContentInteractor {
    suspend fun data(): ContentResult
    class Base(
        private val repository: ContentRepository,
        private val handleError: HandleError<DomainException, String>,
        private val mapper: NewsUiMapper
    ) : ContentInteractor {
        override suspend fun data(): ContentResult =
            try {
                val list = repository.data()
                ContentResult.Success(list.filter { it.isValid() }
                    .map { it.map(mapper) }) //todo interactor should'nt map in clean arch
            } catch (e: DomainException) {
                ContentResult.Error(handleError.handle(e))
            }
    }
}