package com.puj.testtaskonlineshop.di

import android.app.Application
import com.puj.testtaskonlineshop.data.GoodsRepositoryImpl
import com.puj.testtaskonlineshop.data.UserRepositoryImpl
import com.puj.testtaskonlineshop.data.database.TestTaskOnlineShopDatabase
import com.puj.testtaskonlineshop.data.database.dao.UserDao
import com.puj.testtaskonlineshop.data.network.GoodsRemoteDataSource
import com.puj.testtaskonlineshop.data.network.GoodsRemoteDataSourceImpl
import com.puj.testtaskonlineshop.domain.GoodsRepository
import com.puj.testtaskonlineshop.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun userRepository(impl: UserRepositoryImpl): UserRepository

    @ApplicationScope
    @Binds
    fun goodsRepository(impl: GoodsRepositoryImpl): GoodsRepository

    @ApplicationScope
    @Binds
    fun goodsRemoteDataSource(impl: GoodsRemoteDataSourceImpl): GoodsRemoteDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideUserDao(
            application: Application
        ): UserDao {
            return TestTaskOnlineShopDatabase.getInstance(application).userDao()
        }
    }
}