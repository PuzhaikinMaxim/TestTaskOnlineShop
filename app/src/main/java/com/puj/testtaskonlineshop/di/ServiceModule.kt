package com.puj.testtaskonlineshop.di

import com.puj.testtaskonlineshop.data.network.GoodsApiService
import com.puj.testtaskonlineshop.data.network.ServiceFactory
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun getGoodsApiService(): GoodsApiService {
        return ServiceFactory.create(GoodsApiService::class.java)
    }
}