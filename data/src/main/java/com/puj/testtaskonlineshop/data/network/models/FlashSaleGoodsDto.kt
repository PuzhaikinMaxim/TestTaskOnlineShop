package com.puj.testtaskonlineshop.data.network.models

import com.google.gson.annotations.SerializedName

data class FlashSaleGoodsDto(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int,
    @SerializedName("image_url")
    val imageUrl: String
) {
}