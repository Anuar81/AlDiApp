package com.example.aldiapp.ui.add

import android.text.Editable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aldiapp.data.ItemRepository
import com.example.aldiapp.domain.Item
import com.google.android.material.textfield.TextInputEditText
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

    fun isAllCompleted(
        txtAppName: TextInputEditText,
        txtAppUser: TextInputEditText,
        txtAppPass: TextInputEditText,
        errorText: String
    ): Boolean = if (!txtAppName.text.isNullOrBlank() &&
        !txtAppUser.text.isNullOrBlank() &&
        !txtAppPass.text.isNullOrBlank()
    ) {
        true
    } else {
        setErrors(txtAppName, txtAppUser, txtAppPass, errorText)
        false
    }

    private fun setErrors(
        txtAppName: TextInputEditText,
        txtAppUser: TextInputEditText,
        txtAppPass: TextInputEditText,
        errorText: String
    ) {
        if (txtAppName.text.isNullOrBlank()) {
            txtAppName.error = errorText
        }
        if (txtAppUser.text.isNullOrBlank()) {
            txtAppUser.error = errorText
        }
        if (txtAppPass.text.isNullOrBlank()) {
            txtAppPass.error = errorText
        }
    }
}