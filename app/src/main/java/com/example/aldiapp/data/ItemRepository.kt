package com.example.aldiapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aldiapp.db.ItemDAO
import com.example.aldiapp.domain.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDAO: ItemDAO){

    suspend fun addItemToList(item: Item) {
        itemDAO.addItemToList(item)
    }

    suspend fun getAllItems() : List<Item> {
        return itemDAO.getAllItems()
    }

    suspend fun updateItem(item: Item) {
        itemDAO.updateItem(item)
    }

}