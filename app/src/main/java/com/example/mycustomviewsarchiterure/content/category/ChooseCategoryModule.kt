package com.example.mycustomviewsarchiterure.content.category

import com.example.mycustomviewsarchiterure.content.category.data.ChosenCategory
import com.example.mycustomviewsarchiterure.content.category.data.NewsCategories
import com.example.mycustomviewsarchiterure.content.category.presentation.CategoriesCommunication
import com.example.mycustomviewsarchiterure.content.category.presentation.ChooseCategoryViewModel
import com.example.mycustomviewsarchiterure.core.Core
import com.example.mycustomviewsarchiterure.core.Module

class ChooseCategoryModule(
    private val core: Core
) : Module<ChooseCategoryViewModel> {
    override fun viewModel(): ChooseCategoryViewModel {
        val newsCategories = NewsCategories.Base()
        return ChooseCategoryViewModel(
            core.settingsChangedCommunication(),
            CategoriesCommunication.Base(),
            ChosenCategory.Base(newsCategories, core.storage()),
            newsCategories
        )
    }
}