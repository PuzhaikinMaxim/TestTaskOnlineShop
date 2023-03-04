package com.puj.testtaskonlineshop.domain.models

data class FlashSaleGoods(
    val category: String,
    val name: String,
    val price: Int,
    val discount: Int,
    val imageUrl: String
)