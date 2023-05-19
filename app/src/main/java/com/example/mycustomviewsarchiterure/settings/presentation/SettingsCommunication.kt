package com.example.mycustomviewsarchiterure.settings.presentation

import android.widget.RadioButton
import com.example.mycustomviewsarchiterure.content.presentation.ContentUiState
import com.example.mycustomviewsarchiterure.core.Communication

interface SettingsCommunication : Communication.Mutable<SettingsUiState> {
    class Base : Communication.Abstract<SettingsUiState>(), SettingsCommunication

}