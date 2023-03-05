package com.puj.testtaskonlineshop.domain

import androidx.lifecycle.LiveData
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import com.puj.testtaskonlineshop.domain.models.LatestGoods

interface GoodsRepository {

    fun getFlashSaleGoods(): LiveData<List<FlashSaleGoods>>

    fun getLatestGoods(): LiveData<List<LatestGoods>>

    fun setGoodsList()
}