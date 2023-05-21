package com.example.mycustomviewsarchiterure.content.settings

import com.example.mycustomviewsarchiterure.core.Communication

interface SettingCommunication : Communication.Mutable<SettingUiState> {
    class Base : Communication.Abstract<SettingUiState>(), SettingCommunication
}