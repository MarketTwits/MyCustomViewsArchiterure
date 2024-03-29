package com.example.mycustomviewsarchiterure.content

import com.example.mycustomviewsarchiterure.content.category.data.ChosenCategory
import com.example.mycustomviewsarchiterure.content.category.data.NewsCategories
import com.example.mycustomviewsarchiterure.content.data.ContentCloudDataSource
import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.content.data.MakeNewsService
import com.example.mycustomviewsarchiterure.content.domain.BaseContentRepository
import com.example.mycustomviewsarchiterure.content.domain.ContentInteractor
import com.example.mycustomviewsarchiterure.content.domain.HandleError
import com.example.mycustomviewsarchiterure.content.domain.NewsUiMapper
import com.example.mycustomviewsarchiterure.content.content.ContentCommunication
import com.example.mycustomviewsarchiterure.content.content.ContentViewModel
import com.example.mycustomviewsarchiterure.core.Core
import com.example.mycustomviewsarchiterure.core.DispatchersList
import com.example.mycustomviewsarchiterure.core.Module

class ContentModule(private val core: Core) : Module<ContentViewModel> {
    override fun viewModel(): ContentViewModel {

        val loadingModeCache = LoadingModeCache.Base(core.storage())
        val service = MakeNewsService.Base()
        val cloudDataSource = ContentCloudDataSource.Base(
            ChosenCategory.Base(NewsCategories.Base(), core.storage()),
            service.service()
        )
        val handleErrorData = HandleError.Data()
        val handleErrorDomain = HandleError.Domain(core.manageResource())
        val repository = BaseContentRepository(cloudDataSource, handleErrorData)
        val newsUiMapper = NewsUiMapper.Base(loadingModeCache)

        return ContentViewModel(
            core.navigation(),
            core.settingsChangedCommunication(),
            ContentCommunication.Base(),
            DispatchersList.Base(),
            ContentInteractor.Base(
                repository,
                handleErrorDomain,
                newsUiMapper
            )
        )
    }
}