package com.puj.testtaskonlineshop.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.puj.testtaskonlineshop.data.database.dao.UserDao
import com.puj.testtaskonlineshop.data.database.models.UserDbModel

@Database(entities = [
    UserDbModel::class
], version = 1, exportSchema = false)
abstract class TestTaskOnlineShopDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var INSTANCE: TestTaskOnlineShopDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "test_task_online_shop.db"

        fun getInstance(application: Application): TestTaskOnlineShopDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    TestTaskOnlineShopDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}