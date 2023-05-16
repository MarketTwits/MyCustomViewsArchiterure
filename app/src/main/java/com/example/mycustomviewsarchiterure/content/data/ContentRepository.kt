package com.example.mycustomviewsarchiterure.content.data

import com.example.mycustomviewsarchiterure.content.domain.NewsDomain

interface ContentRepository {
    suspend fun data() : List<NewsDomain>
}