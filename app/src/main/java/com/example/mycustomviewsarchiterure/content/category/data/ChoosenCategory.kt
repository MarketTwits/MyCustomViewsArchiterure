package com.example.mycustomviewsarchiterure.content.category.data

import com.example.mycustomviewsarchiterure.core.Storage

interface ChosenCategory {
    interface Save{
        fun save(category : String)
    }
    interface Read{
        fun chosenCategory() : String
    }
    interface Mutable : Save, Read
    class Base(
        private val newsCategories: NewsCategories,
        private val storage : Storage,
        private val key : String = "chosenCategoryString"
    ) : Mutable{
        override fun save(category: String) = storage.save(key, category)

        override fun chosenCategory(): String = newsCategories.chosenCategory(key, storage)

    }
}