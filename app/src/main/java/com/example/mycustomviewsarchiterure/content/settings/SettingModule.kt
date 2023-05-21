package com.example.mycustomviewsarchiterure.content.settings

import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.core.Core
import com.example.mycustomviewsarchiterure.core.Module

class SettingModule(private val core: Core) : Module<SettingViewModel> {
    override fun viewModel() = SettingViewModel(
        SettingCommunication.Base(),
        core.settingsChangedCommunication(),
        LoadingModeCache.Base(core.storage())
    )
}