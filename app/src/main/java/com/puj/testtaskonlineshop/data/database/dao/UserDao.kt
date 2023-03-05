package com.puj.testtaskonlineshop.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puj.testtaskonlineshop.data.database.models.UserDbModel

@Dao
interface UserDao {

    @Query("SELECT * FROM user u WHERE u.firstName = :firstName LIMIT 1")
    suspend fun getUserByFirstName(firstName: String): UserDbModel?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(userDbModel: UserDbModel)
}