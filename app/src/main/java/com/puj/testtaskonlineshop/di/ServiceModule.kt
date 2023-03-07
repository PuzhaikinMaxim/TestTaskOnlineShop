package com.puj.testtaskonlineshop.di

import com.puj.testtaskonlineshop.data.network.goods.GoodsApiService
import com.puj.testtaskonlineshop.data.network.ServiceFactory
import com.puj.testtaskonlineshop.data.network.product.ProductApiService
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun getGoodsApiService(): GoodsApiService {
        return ServiceFactory.create(GoodsApiService::class.java)
    }

    @Provides
    fun getProductApiService(): ProductApiService {
        return ServiceFactory.create(ProductApiService::class.java)
    }
}