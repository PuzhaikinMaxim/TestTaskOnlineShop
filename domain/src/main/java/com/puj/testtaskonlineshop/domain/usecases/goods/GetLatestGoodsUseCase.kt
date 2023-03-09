package com.puj.testtaskonlineshop.domain.usecases.goods

import androidx.lifecycle.LiveData
import com.puj.testtaskonlineshop.domain.GoodsRepository
import com.puj.testtaskonlineshop.domain.models.LatestGoods
import javax.inject.Inject

class GetLatestGoodsUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
){

    operator fun invoke(): LiveData<List<LatestGoods>> {
        return goodsRepository.getLatestGoods()
    }
}