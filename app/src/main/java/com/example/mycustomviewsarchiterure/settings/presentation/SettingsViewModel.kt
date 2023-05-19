package com.example.mycustomviewsarchiterure.settings.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.core.Communication
import com.example.mycustomviewsarchiterure.core.Init
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsViewModel(
    private val loadingModeCache: LoadingModeCache.Mutable,
    private val communication: SettingsCommunication,
    private val settingsCommunication: SettingsChangedCommunication.Update
) : ViewModel() , Init, Communication.Observe<SettingsUiState>{

    override fun observe(owner: LifecycleOwner, observer: Observer<SettingsUiState>) {
        communication.observe(owner, observer)
    }

    override fun init(firstRun: Boolean) {
        if(firstRun)
            communication.map(SettingsUiState.Initial(loadingModeCache.isWifiOnly()))
    }
    fun choseWifiOnly() {
        loadingModeCache.save(true)
        settingsCommunication.map(true)
    }
    fun chooseAlsoMobile() {
        loadingModeCache.save(false)
        settingsCommunication.map(true)
    }

}