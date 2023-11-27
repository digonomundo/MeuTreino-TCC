package com.example.vamostcc.view.telaprincipal.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ESSA PORRA É A FRAGMENT HOME"
    }
    val text: LiveData<String> = _text
}