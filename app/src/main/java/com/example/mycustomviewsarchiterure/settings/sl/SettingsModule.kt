package com.example.mycustomviewsarchiterure.settings.sl

import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.core.Core
import com.example.mycustomviewsarchiterure.core.Module
import com.example.mycustomviewsarchiterure.settings.presentation.SettingsChangedCommunication
import com.example.mycustomviewsarchiterure.settings.presentation.SettingsCommunication
import com.example.mycustomviewsarchiterure.settings.presentation.SettingsViewModel

class SettingsModule(private val core: Core) : Module<SettingsViewModel> {
    val loadingModeCache = LoadingModeCache.Base(core.storage())
    val communication = SettingsCommunication.Base()

    override fun viewModel(): SettingsViewModel {
        return SettingsViewModel(
            loadingModeCache,
            communication,
            core.settingsChanged()
        )
    }
}