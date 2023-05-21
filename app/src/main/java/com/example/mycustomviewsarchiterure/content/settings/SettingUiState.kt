package com.example.mycustomviewsarchiterure.content.settings

import android.widget.RadioButton
import com.example.mycustomviewsarchiterure.content.presentation.ContentUiState

interface SettingUiState {
    fun showChoice(wifiOnlyRadioButton: RadioButton, alsoMobileRadioButton: RadioButton) = Unit

    class Initial(private val wifiOnlyChosen: Boolean) : SettingUiState {
        override fun showChoice(
            wifiOnlyRadioButton: RadioButton,
            alsoMobileRadioButton: RadioButton
        ) {
            wifiOnlyRadioButton.isChecked = wifiOnlyChosen
            alsoMobileRadioButton.isChecked = !wifiOnlyChosen
        }
    }
}