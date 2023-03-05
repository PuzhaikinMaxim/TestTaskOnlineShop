package com.puj.testtaskonlineshop.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.puj.testtaskonlineshop.domain.usecases.goods.GetFlashSaleGoodsUseCase
import com.puj.testtaskonlineshop.domain.usecases.goods.GetLatestGoodsUseCase
import com.puj.testtaskonlineshop.domain.usecases.goods.SetGoodsListUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    getFlashSaleGoodsUseCase: GetFlashSaleGoodsUseCase,
    getLatestGoodsUseCase: GetLatestGoodsUseCase,
    setGoodsListUseCase: SetGoodsListUseCase
): ViewModel() {

    val flashSaleGoods = getFlashSaleGoodsUseCase()

    val latestGoods = getLatestGoodsUseCase()

    init {
        setGoodsListUseCase()
    }
}