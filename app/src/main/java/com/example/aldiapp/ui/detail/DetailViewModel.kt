package com.example.aldiapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.aldiapp.domain.Item

class DetailViewModel @ViewModelInject constructor(): ViewModel() {
    var item : Item? = null
    var isEditable = false


}