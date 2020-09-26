package com.example.aldiapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aldiapp.domain.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun getItemDAO(): ItemDAO
}