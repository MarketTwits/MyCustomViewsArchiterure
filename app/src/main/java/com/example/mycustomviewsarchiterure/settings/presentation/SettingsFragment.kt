package com.example.mycustomviewsarchiterure.settings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.mycustomviewsarchiterure.R
import com.example.mycustomviewsarchiterure.core.ProvideViewModel

class SettingsFragment : Fragment() {
    private lateinit var viewModel: SettingsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(this, SettingsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wifiOnlyRadioButton : RadioButton = view.findViewById(R.id.wifiOnlyRadioButton)
        val alsoMobileRadioButton : RadioButton = view.findViewById(R.id.wifiPlusMobileSourceRadioButton)

        viewModel.observe(this){
            it.showChoice(wifiOnlyRadioButton, alsoMobileRadioButton)
        }
        viewModel.init(savedInstanceState == null)

        wifiOnlyRadioButton.setOnClickListener {
            viewModel.choseWifiOnly()
        }
        alsoMobileRadioButton.setOnClickListener {
            viewModel.chooseAlsoMobile()
        }
    }
}
