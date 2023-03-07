package com.puj.testtaskonlineshop.data.network.goods

import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsDto
import com.puj.testtaskonlineshop.data.network.models.LatestGoodsDto
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import com.puj.testtaskonlineshop.domain.models.LatestGoods

interface GoodsRemoteDataSource {

    suspend fun getFlashSaleGoods(): List<FlashSaleGoodsDto>

    suspend fun getLatestGoods(): List<LatestGoodsDto>
}