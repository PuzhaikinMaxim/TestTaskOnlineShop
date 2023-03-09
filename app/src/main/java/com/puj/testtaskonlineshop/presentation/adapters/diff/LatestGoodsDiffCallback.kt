package com.puj.testtaskonlineshop.presentation.adapters.diff

import com.puj.testtaskonlineshop.domain.models.LatestGoods

class LatestGoodsDiffCallback(
    private val oldList: List<LatestGoods>,
    private val newList: List<LatestGoods>
): SimpleDiffCallback<LatestGoods>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}