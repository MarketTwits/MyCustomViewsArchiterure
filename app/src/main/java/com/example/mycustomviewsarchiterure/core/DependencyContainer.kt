package com.example.mycustomviewsarchiterure.core

import androidx.lifecycle.ViewModel
import com.example.mycustomviewsarchiterure.content.ContentModule
import com.example.mycustomviewsarchiterure.content.presentation.ContentViewModel
import com.example.mycustomviewsarchiterure.main.MainModule
import com.example.mycustomviewsarchiterure.main.MainViewModel
import com.example.mycustomviewsarchiterure.settings.presentation.SettingsViewModel
import com.example.mycustomviewsarchiterure.settings.sl.SettingsModule

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
            SettingsViewModel::class.java -> SettingsModule(core)
            else -> dependencyContainer.module(className)
        }
    }
}
