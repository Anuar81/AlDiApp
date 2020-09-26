package com.example.aldiapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aldiapp.domain.Item

@Dao
interface ItemDAO {

    @Query("SELECT * FROM Item")
    suspend fun getAllItems(): List<Item>

    @Insert
    suspend fun addItemToList(item: Item)

    @Delete
    suspend fun removeItemFromList(item: Item)
}