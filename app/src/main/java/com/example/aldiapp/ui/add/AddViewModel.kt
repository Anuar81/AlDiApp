package com.example.aldiapp.ui.add

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aldiapp.data.ItemRepository
import com.example.aldiapp.domain.Item
import kotlinx.coroutines.launch

class AddViewModel @ViewModelInject constructor(private val repository: ItemRepository) :
    ViewModel() {
    private var _addSuccessLiveData = MutableLiveData<Boolean>().apply { value = false }
    val addSuccecsLivedata: LiveData<Boolean> = _addSuccessLiveData

    fun addItem(item: Item) {
        viewModelScope.launch {
            repository.addItemToList(item)
            _addSuccessLiveData.value = true
        }
    }
}