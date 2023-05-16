package com.example.mycustomviewsarchiterure.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mycustomviewsarchiterure.content.presentation.ContentScreen
import com.example.mycustomviewsarchiterure.core.Communication
import com.example.mycustomviewsarchiterure.core.Init

class MainViewModel(
    private val communication : NavigationCommunication.Mutable
) : ViewModel(), Communication.Observe<Screen>, Init {
    override fun observe(owner: LifecycleOwner, observer: Observer<Screen>) {
        super.observe(owner, observer)
        communication.observe(owner, observer)
    }

    override fun init(firstRun : Boolean){
        if (firstRun){
            communication.map(ContentScreen())
        }
    }
}