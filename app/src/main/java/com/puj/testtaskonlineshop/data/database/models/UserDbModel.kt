package com.puj.testtaskonlineshop.data.database.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user", indices = [Index(value = ["email"], unique = true)])
data class UserDbModel(
    @PrimaryKey
    val firstName: String,
    val lastName: String,
    val email: String
)