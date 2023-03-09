package com.puj.testtaskonlineshop.domain.usecases.goods

import androidx.lifecycle.LiveData
import com.puj.testtaskonlineshop.domain.GoodsRepository
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import javax.inject.Inject

class GetFlashSaleGoodsUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {

    operator fun invoke(): LiveData<List<FlashSaleGoods>> {
        return goodsRepository.getFlashSaleGoods()
    }
}