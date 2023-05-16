package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.core.ManageResource
import java.net.ConnectException
import java.net.UnknownHostException
import kotlin.Exception

interface HandleError<E : Exception, T : Any> {
    fun handle(error: E): T
    class Domain(
        private val manageResource: ManageResource
    ) : HandleError<DomainException, String> {
        override fun handle(error: DomainException): String = error.handle(manageResource)
    }
    class Data : HandleError<Exception, DomainException>{
        override fun handle(error: Exception): DomainException {
            return  if (error is ConnectException || error is UnknownHostException)
                return DomainException.NoConnectionException
            else DomainException.ServiceUnavailableException
        }
    }
}