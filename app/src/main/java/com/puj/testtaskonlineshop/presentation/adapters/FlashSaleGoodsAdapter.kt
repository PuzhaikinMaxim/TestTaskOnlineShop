package com.puj.testtaskonlineshop.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.ItemFlashSaleBinding
import com.puj.testtaskonlineshop.domain.models.FlashSaleGoods
import com.puj.testtaskonlineshop.presentation.adapters.diff.FlashSaleGoodsDiffCallback
import com.puj.testtaskonlineshop.presentation.adapters.viewholders.FlashSaleViewHolder
import com.squareup.picasso.Picasso

class FlashSaleGoodsAdapter(
    context: Context
): Adapter<FlashSaleViewHolder>() {

    var latestGoodsList = emptyList<FlashSaleGoods>()
        set(value) {
            val diffCallback = FlashSaleGoodsDiffCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    private var context: Context? = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val binding = ItemFlashSaleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FlashSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val item = latestGoodsList[position]

        with(holder.binding){
            loadImageBitmap(item.imageUrl, ivBackground)
            tvName.text = item.name
            tvCategory.text = item.category
            tvPrice.text = context?.getString(
                R.string.price,
                item.price.toString()
            ) ?: ""
            tvDiscount.text = context?.getString(
                R.string.discount,
                item.discount
            )
        }
    }

    private fun loadImageBitmap(url: String, target: ImageView){
        Picasso.get().load(url).into(target)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        context = null
    }

    override fun getItemCount(): Int {
        return latestGoodsList.size
    }
}