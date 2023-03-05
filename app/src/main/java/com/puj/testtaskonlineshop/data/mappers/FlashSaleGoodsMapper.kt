package com.puj.testtaskonlineshop.data.mappers

import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsDto
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import javax.inject.Inject

class FlashSaleGoodsMapper @Inject constructor(){

    fun mapFlashSaleGoodsDtoToFlashSaleGoods(
        flashSaleGoodsDto: FlashSaleGoodsDto
    ): FlashSaleGoods {
        return FlashSaleGoods(
            category = flashSaleGoodsDto.category,
            name = flashSaleGoodsDto.name,
            price = flashSaleGoodsDto.price,
            discount = flashSaleGoodsDto.discount,
            imageUrl = flashSaleGoodsDto.imageUrl
        )
    }

    fun mapFlashSaleGoodsDtoListToFlashSaleGoodsList(
        list: List<FlashSaleGoodsDto>
    ): List<FlashSaleGoods> {
        val newList = arrayListOf<FlashSaleGoods>()
        for (elem in list) {
            newList.add(mapFlashSaleGoodsDtoToFlashSaleGoods(elem))
        }
        return newList
    }
}