package com.example.mycustomviewsarchiterure.core

import android.content.Context
import com.example.mycustomviewsarchiterure.main.NavigationCommunication

class Core(private val context: Context
) : ProvideNavigation, ProvideStorage, ProvideManageResource {

    private val navigation = NavigationCommunication.Base()
    private val manageResource = ManageResource.Base(context)
    private val storage =
        Storage.Base(context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE))

    override fun navigation(): NavigationCommunication.Mutable {
        return navigation
    }

    override fun storage(): Storage = storage

    companion object {
        private const val STORAGE_NAME = "NEWS APP DATA"
    }

    override fun manageResource(): ManageResource  = manageResource
}

interface ProvideNavigation {
    fun navigation(): NavigationCommunication.Mutable
}

interface ProvideStorage {
    fun storage(): Storage
}
interface ProvideManageResource{
    fun manageResource() : ManageResource
}