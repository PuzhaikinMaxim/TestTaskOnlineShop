package com.puj.testtaskonlineshop.domain.usecases.goods

import com.puj.testtaskonlineshop.domain.GoodsRepository
import javax.inject.Inject

class SetGoodsListUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository
) {

    operator fun invoke() {
        goodsRepository.setGoodsList()
    }
}