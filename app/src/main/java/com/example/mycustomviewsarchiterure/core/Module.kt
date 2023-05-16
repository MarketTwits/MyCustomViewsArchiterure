package com.example.mycustomviewsarchiterure.core

import androidx.lifecycle.ViewModel

interface Module<T : ViewModel> {
    fun viewModel() : T
}