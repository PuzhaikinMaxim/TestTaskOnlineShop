package com.puj.testtaskonlineshop.data.network

import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsListDto
import com.puj.testtaskonlineshop.data.network.models.LatestGoodsListDto
import retrofit2.Response
import retrofit2.http.GET

interface GoodsApiService {

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSaleGoods(): Response<FlashSaleGoodsListDto>

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestGoods(): Response<LatestGoodsListDto>
}