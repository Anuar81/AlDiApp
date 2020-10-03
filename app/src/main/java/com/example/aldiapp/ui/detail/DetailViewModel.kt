package com.example.aldiapp.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aldiapp.data.ItemRepository
import com.example.aldiapp.domain.Item
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(private val repository: ItemRepository): ViewModel() {
    var item : Item? = null
    var isEditable = false

    fun updateItem() {
        viewModelScope.launch {
            item?.let {
                repository.updateItem(it)
            }
        }
    }
}