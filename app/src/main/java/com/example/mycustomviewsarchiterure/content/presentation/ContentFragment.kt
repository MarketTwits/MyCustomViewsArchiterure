package com.example.mycustomviewsarchiterure.content.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.mycustomviewsarchiterure.R
import com.example.mycustomviewsarchiterure.core.ProvideViewModel

class ContentFragment : Fragment() {
    private lateinit var viewModel : ContentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as ProvideViewModel).viewModel(this, ContentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wifiOnlyRadioButton : RadioButton = view.findViewById(R.id.wifiOnlyRadioButton)
        val alsoMobileRadioButton : RadioButton = view.findViewById(R.id.wifiPlusMobileSourceRadioButton)
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = NewsAdapter()

        wifiOnlyRadioButton.setOnClickListener {
            viewModel.choseWifiOnly()
        }
        alsoMobileRadioButton.setOnClickListener {
            viewModel.chooseAlsoMobile()
        }

        recyclerView.adapter = adapter
        viewModel.observe(this,  Observer{
            it.showChoice(wifiOnlyRadioButton, alsoMobileRadioButton)
            it.showNews(adapter)
        })
        viewModel.init(savedInstanceState == null)

    }
}