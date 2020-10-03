package com.example.aldiapp.db

import androidx.room.*
import com.example.aldiapp.domain.Item

@Dao
interface ItemDAO {

    @Query("SELECT * FROM Item")
    suspend fun getAllItems(): List<Item>

    @Insert
    suspend fun addItemToList(item: Item)

    @Delete
    suspend fun removeItemFromList(item: Item)

    @Update
    suspend fun updateItem(item: Item)
}