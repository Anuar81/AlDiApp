package com.example.aldiapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    var title: String,
    var userName: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}