package com.example.mycustomviewsarchiterure.core

import android.content.Context
import com.example.mycustomviewsarchiterure.content.settings.SettingsChangedCommunication
import com.example.mycustomviewsarchiterure.main.NavigationCommunication

class Core(
    private val context: Context
) : ProvideNavigation, ProvideStorage, ProvideManageResource, ProvideSettingsChangedCommunication {

    private val navigation = NavigationCommunication.Base()
    private val manageResource = ManageResource.Base(context)
    private val storage =
        Storage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))
    private val settingsChangedCommunication: SettingsChangedCommunication.Mutable =
        SettingsChangedCommunication.Base()

    override fun navigation(): NavigationCommunication.Mutable {
        return navigation
    }

    override fun storage(): Storage = storage

    companion object {
        private const val STORAGE_NAME = "NEWS APP DATA"
    }

    override fun manageResource(): ManageResource = manageResource
    override fun settingsChangedCommunication() = settingsChangedCommunication
}

interface ProvideNavigation {
    fun navigation(): NavigationCommunication.Mutable
}

interface ProvideStorage {
    fun storage(): Storage
}

interface ProvideManageResource {
    fun manageResource(): ManageResource
}

interface ProvideSettingsChangedCommunication {
    fun settingsChangedCommunication(): SettingsChangedCommunication.Mutable
}