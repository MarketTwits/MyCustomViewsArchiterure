package com.example.mycustomviewsarchiterure.content.content

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycustomviewsarchiterure.content.domain.ContentInteractor
import com.example.mycustomviewsarchiterure.content.settings.SettingsChangedCommunication
import com.example.mycustomviewsarchiterure.content.settings.SettingsScreen
import com.example.mycustomviewsarchiterure.core.Communication
import com.example.mycustomviewsarchiterure.core.DispatchersList
import com.example.mycustomviewsarchiterure.core.Init
import com.example.mycustomviewsarchiterure.main.NavigationCommunication
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val navigationCommunication: NavigationCommunication.Update,
    private val settingsChangedCommunication: SettingsChangedCommunication.Observe,
    private val communication : ContentCommunication,
    private val dispatchersList: DispatchersList,
    private val interactor: ContentInteractor
) : ViewModel(), Communication.Observe<ContentUiState>, Init, Load {
    override fun observe(owner: LifecycleOwner, observer: Observer<ContentUiState>) {
        communication.observe(owner, observer)
    }
    override fun init(firstRun: Boolean) {
        if (firstRun){
           load()
        }
    }
    override fun load(){
        viewModelScope.launch(dispatchersList.io()) {
            val result = interactor.data()
            withContext(dispatchersList.ui()){
                result.map(communication)
            }
        }
    }
    fun observeSettingChanged(owner: LifecycleOwner, observer : Observer<Boolean>) =
        settingsChangedCommunication.observe(owner, observer)
    fun showSettings(){
        navigationCommunication.map(SettingsScreen)
    }
}
interface Load{
    fun load()
}