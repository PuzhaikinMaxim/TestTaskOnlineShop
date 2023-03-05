package com.puj.testtaskonlineshop.data.network.models

import com.google.gson.annotations.SerializedName

data class LatestGoodsDto(
    val category: String,
    val name: String,
    val price: Double,
    @SerializedName("image_url")
    val imageUrl: String
) {
}