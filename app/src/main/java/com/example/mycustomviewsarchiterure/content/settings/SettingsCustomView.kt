package com.example.mycustomviewsarchiterure.content.settings

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RadioButton
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.mycustomviewsarchiterure.R
import com.example.mycustomviewsarchiterure.content.presentation.NewsAdapter
import com.example.mycustomviewsarchiterure.core.ProvideViewModel

class SettingsCustomView : FrameLayout {
    private lateinit var viewModel: SettingViewModel

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inflate(context, R.layout.settings_view, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        viewModel = (context.applicationContext as ProvideViewModel)
            .viewModel(
                findViewTreeViewModelStoreOwner()!!,
                SettingViewModel::class.java
            )
        val wifiOnlyRadioButton: RadioButton = findViewById(R.id.wifiOnlyRadioButton)
        val alsoMobileRadioButton: RadioButton = findViewById(R.id.wifiPlusMobileSourceRadioButton)

        wifiOnlyRadioButton.setOnClickListener {
            viewModel.choseWifiOnly()
        }
        alsoMobileRadioButton.setOnClickListener {
            viewModel.chooseAlsoMobile()
        }

        viewModel.observe(findViewTreeLifecycleOwner()!!) {
            it.showChoice(wifiOnlyRadioButton, alsoMobileRadioButton)
        }
    }
}