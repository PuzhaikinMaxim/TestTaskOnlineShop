package com.puj.testtaskonlineshop.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDbModel(
    @PrimaryKey
    val firstName: String,
    val lastName: String,
    val email: String
)