package com.example.mycustomviewsarchiterure.content.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycustomviewsarchiterure.content.data.LoadingModeCache
import com.example.mycustomviewsarchiterure.content.domain.ContentInteractor
import com.example.mycustomviewsarchiterure.core.Communication
import com.example.mycustomviewsarchiterure.core.DispatchersList
import com.example.mycustomviewsarchiterure.core.Init
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentViewModel(
    private val communication : ContentCommunication,
    private val loadingModeCache: LoadingModeCache.Mutable,
    private val dispatchersList: DispatchersList,
    private val interactor: ContentInteractor
) : ViewModel(), Communication.Observe<ContentUiState>, Init {
    override fun observe(owner: LifecycleOwner, observer: Observer<ContentUiState>) {
        communication.observe(owner, observer)
    }
    override fun init(firstRun: Boolean) {
        if (firstRun){
            communication.map(ContentUiState.Initial(loadingModeCache.isWifiOnly()))
           load()
        }
    }
    fun choseWifiOnly() {
        loadingModeCache.save(true)
        load()
    }
    fun chooseAlsoMobile() {
       loadingModeCache.save(false)
        load()
    }
    private fun load(){
        viewModelScope.launch(dispatchersList.io()) {
            val result = interactor.data()
            withContext(dispatchersList.ui()){
                result.map(communication)
            }
        }
    }
}