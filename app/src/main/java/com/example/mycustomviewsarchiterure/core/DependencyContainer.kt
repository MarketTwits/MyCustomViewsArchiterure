package com.example.mycustomviewsarchiterure.core

import androidx.lifecycle.ViewModel
import com.example.mycustomviewsarchiterure.content.ContentModule
import com.example.mycustomviewsarchiterure.content.category.ChooseCategoryModule
import com.example.mycustomviewsarchiterure.content.category.presentation.ChooseCategoryViewModel
import com.example.mycustomviewsarchiterure.content.content.ContentViewModel
import com.example.mycustomviewsarchiterure.content.settings.SettingModule
import com.example.mycustomviewsarchiterure.content.settings.SettingViewModel
import com.example.mycustomviewsarchiterure.main.MainModule
import com.example.mycustomviewsarchiterure.main.MainViewModel

interface DependencyContainer {
    fun module(className: Class<out ViewModel>): Module<out ViewModel>
    class Error : DependencyContainer {
        override fun module(className: Class<out ViewModel>): Module<out ViewModel> {
            throw IllegalArgumentException("unknown className $className")
        }
    }
    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {
        override fun module(className: Class<out ViewModel>) = when (className) {
            MainViewModel::class.java -> MainModule(core)
            ContentViewModel::class.java -> ContentModule(core)
            SettingViewModel::class.java -> SettingModule(core)
            ChooseCategoryViewModel::class.java -> ChooseCategoryModule(core)
            else -> dependencyContainer.module(className)
        }
    }
}
