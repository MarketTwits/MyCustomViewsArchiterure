package com.example.mycustomviewsarchiterure.content.domain

import com.example.mycustomviewsarchiterure.R
import com.example.mycustomviewsarchiterure.core.ManageResource

abstract class DomainException(
    private val id : Int
) : Exception() {
    fun handle(manageResource: ManageResource) = manageResource.string(id)
    object NoConnectionException : DomainException(R.string.no_connection_exception)
    object ServiceUnavailableException : DomainException(R.string.service_unavaliable)
}