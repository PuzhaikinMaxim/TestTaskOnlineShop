package com.puj.testtaskonlineshop.data.network.models

import com.google.gson.annotations.SerializedName

data class LatestGoodsListDto(
    @SerializedName("latest")
    val latestGoodsList: List<LatestGoodsDto>
) {
}