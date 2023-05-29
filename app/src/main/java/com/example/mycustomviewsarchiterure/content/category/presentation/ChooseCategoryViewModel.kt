package com.example.mycustomviewsarchiterure.content.category.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mycustomviewsarchiterure.content.category.data.ChosenCategory
import com.example.mycustomviewsarchiterure.content.category.data.NewsCategories
import com.example.mycustomviewsarchiterure.content.category.data.NewsCategory
import com.example.mycustomviewsarchiterure.content.settings.SettingsChangedCommunication
import com.example.mycustomviewsarchiterure.core.Communication


class ChooseCategoryViewModel(
    private val settingsChangedCommunication: SettingsChangedCommunication.Update,
    private val communication : CategoriesCommunication,
    private val chosenCategory : ChosenCategory.Mutable,
    private val newsCategory: NewsCategories
) : ViewModel(), Communication.Observe<CategoriesUiState>, ChooseCategory {
    private val list : List<NewsCategory>
    init {
         list = newsCategory.categories(chosenCategory)
        communication.map(CategoriesUiState.Initial(list, this))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<CategoriesUiState>) {
        communication.observe(owner, observer)
    }

    override fun choose(category: String) {
        chosenCategory.save(category)
        communication.map(CategoriesUiState.ChangeChoice(category))
        settingsChangedCommunication.map(true)
    }
}
interface ChooseCategory{
    fun choose(category : String)
}