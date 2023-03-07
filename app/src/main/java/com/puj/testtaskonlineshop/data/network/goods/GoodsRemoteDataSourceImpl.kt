package com.puj.testtaskonlineshop.data.network.goods

import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsDto
import com.puj.testtaskonlineshop.data.network.models.LatestGoodsDto
import javax.inject.Inject

class GoodsRemoteDataSourceImpl @Inject constructor(
    private val service: GoodsApiService
): GoodsRemoteDataSource {

    override suspend fun getFlashSaleGoods(): List<FlashSaleGoodsDto> {
        val response = service.getFlashSaleGoods()
        if(response.isSuccessful){
            return response.body()?.flashSaleGoodsList ?: listOf()
        }
        return listOf()
    }

    override suspend fun getLatestGoods(): List<LatestGoodsDto> {
        val response = service.getLatestGoods()
        if(response.isSuccessful){
            println(response.body())
            return response.body()?.latestGoodsList ?: listOf()
        }
        return listOf()
    }
}