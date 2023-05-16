package com.example.mycustomviewsarchiterure.main


import com.example.mycustomviewsarchiterure.core.Module
import com.example.mycustomviewsarchiterure.core.ProvideNavigation

class MainModule(
    private val core : ProvideNavigation
) : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel(core.navigation())
    }
}