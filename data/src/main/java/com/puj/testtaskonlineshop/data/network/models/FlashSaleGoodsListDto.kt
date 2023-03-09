package com.puj.testtaskonlineshop.data.network.models

import com.google.gson.annotations.SerializedName

class FlashSaleGoodsListDto(
    @SerializedName("flash_sale")
    val flashSaleGoodsList: List<FlashSaleGoodsDto>
) {
}