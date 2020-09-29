package com.example.aldiapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Item(
    var title: String,
    var userName: String,
    var password: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}