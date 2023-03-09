package com.puj.testtaskonlineshop.presentation.adapters.diff

import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods

class FlashSaleGoodsDiffCallback(
    private val oldList: List<FlashSaleGoods>,
    private val newList: List<FlashSaleGoods>
): SimpleDiffCallback<FlashSaleGoods>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}