package com.puj.testtaskonlineshop.di

import android.app.Application
import com.puj.testtaskonlineshop.data.GoodsRepositoryImpl
import com.puj.testtaskonlineshop.data.ProductRepositoryImpl
import com.puj.testtaskonlineshop.data.UserRepositoryImpl
import com.puj.testtaskonlineshop.data.database.TestTaskOnlineShopDatabase
import com.puj.testtaskonlineshop.data.database.dao.UserDao
import com.puj.testtaskonlineshop.data.network.goods.GoodsRemoteDataSource
import com.puj.testtaskonlineshop.data.network.goods.GoodsRemoteDataSourceImpl
import com.puj.testtaskonlineshop.data.network.product.ProductRemoteDataSource
import com.puj.testtaskonlineshop.data.network.product.ProductRemoteDataSourceImpl
import com.puj.testtaskonlineshop.domain.GoodsRepository
import com.puj.testtaskonlineshop.domain.ProductRepository
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

    @ApplicationScope
    @Binds
    fun productRepository(impl: ProductRepositoryImpl): ProductRepository

    @ApplicationScope
    @Binds
    fun productRemoteDataSource(impl: ProductRemoteDataSourceImpl): ProductRemoteDataSource

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