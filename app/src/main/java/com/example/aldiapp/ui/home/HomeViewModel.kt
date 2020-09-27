package com.example.aldiapp.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aldiapp.data.ItemRepository
import com.example.aldiapp.domain.Item
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val repository: ItemRepository) :
    ViewModel() {
    private var _itemList = MutableLiveData<List<Item>>().apply { value = emptyList<Item>() }
    var itemList: LiveData<List<Item>> = _itemList

    fun getAllItems() {
        viewModelScope.launch {
            val items = repository.getAllItems()
            _itemList.value = items
        }
    }
}