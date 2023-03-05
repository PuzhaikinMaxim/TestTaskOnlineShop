package com.puj.testtaskonlineshop.data.mappers

import com.puj.testtaskonlineshop.data.network.models.LatestGoodsDto
import com.puj.testtaskonlineshop.domain.models.LatestGoods
import javax.inject.Inject

class LatestGoodsMapper @Inject constructor(){

    fun mapLatestGoodsDtoToLatestGoods(
        latestGoodsDto: LatestGoodsDto
    ): LatestGoods {
        return LatestGoods(
            category = latestGoodsDto.category,
            name = latestGoodsDto.name,
            price = latestGoodsDto.price,
            imageUrl = latestGoodsDto.imageUrl
        )
    }

    fun mapLatestGoodsDtoListToLatestGoodsList(
        list: List<LatestGoodsDto>
    ): List<LatestGoods> {
        val newList = arrayListOf<LatestGoods>()
        for (elem in list) {
            newList.add(mapLatestGoodsDtoToLatestGoods(elem))
        }
        return newList
    }
}