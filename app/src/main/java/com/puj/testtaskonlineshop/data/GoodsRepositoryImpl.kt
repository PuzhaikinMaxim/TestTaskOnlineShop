package com.puj.testtaskonlineshop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.puj.testtaskonlineshop.data.mappers.FlashSaleGoodsMapper
import com.puj.testtaskonlineshop.data.mappers.LatestGoodsMapper
import com.puj.testtaskonlineshop.data.network.goods.GoodsRemoteDataSource
import com.puj.testtaskonlineshop.data.network.models.FlashSaleGoodsDto
import com.puj.testtaskonlineshop.data.network.models.LatestGoodsDto
import com.puj.testtaskonlineshop.domain.GoodsRepository
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import com.puj.testtaskonlineshop.domain.models.LatestGoods
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(
    private val dataSource: GoodsRemoteDataSource,
    private val flashSaleGoodsMapper: FlashSaleGoodsMapper,
    private val latestGoodsMapper: LatestGoodsMapper
): GoodsRepository {

    private val flashSaleGoodsList = MutableLiveData<List<FlashSaleGoodsDto>>()

    private val latestGoodsList = MutableLiveData<List<LatestGoodsDto>>()

    override fun getFlashSaleGoods(): LiveData<List<FlashSaleGoods>> {
        return Transformations.map(flashSaleGoodsList){
            flashSaleGoodsMapper.mapFlashSaleGoodsDtoListToFlashSaleGoodsList(it)
        }
    }

    override fun getLatestGoods(): LiveData<List<LatestGoods>> {
        return Transformations.map(latestGoodsList){
            latestGoodsMapper.mapLatestGoodsDtoListToLatestGoodsList(it)
        }
    }

    override fun setGoodsList() {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            val flashSaleGoods = dataSource.getFlashSaleGoods()
            val latestGoods = dataSource.getLatestGoods()

            flashSaleGoodsList.postValue(flashSaleGoods)
            latestGoodsList.postValue(latestGoods)
        }
    }
}