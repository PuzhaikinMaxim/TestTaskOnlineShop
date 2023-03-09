package com.puj.testtaskonlineshop.data.network.goods

import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsDto
import com.puj.testtaskonlineshop.data.network.models.LatestGoodsDto

interface GoodsRemoteDataSource {

    suspend fun getFlashSaleGoods(): List<FlashSaleGoodsDto>

    suspend fun getLatestGoods(): List<LatestGoodsDto>
}