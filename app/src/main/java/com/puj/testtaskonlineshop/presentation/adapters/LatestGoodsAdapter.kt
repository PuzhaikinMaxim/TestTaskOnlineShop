package com.puj.testtaskonlineshop.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.puj.testtaskonlineshop.domain.models.LatestGoods
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.ItemLatestGoodsBinding
import com.puj.testtaskonlineshop.presentation.adapters.diff.LatestGoodsDiffCallback
import com.puj.testtaskonlineshop.presentation.adapters.viewholders.LatestGoodsViewHolder
import com.squareup.picasso.Picasso

class LatestGoodsAdapter(
    context: Context
): Adapter<LatestGoodsViewHolder>() {

    var latestGoodsList = emptyList<LatestGoods>()
        set(value) {
            val diffCallback = LatestGoodsDiffCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    private var context: Context? = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestGoodsViewHolder {
        val binding = ItemLatestGoodsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LatestGoodsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestGoodsViewHolder, position: Int) {
        val item = latestGoodsList[position]

        with(holder.binding){
            loadImageBitmap(item.imageUrl, ivBackground)
            tvName.text = item.name
            tvCategory.text = item.category
            tvPrice.text = context?.getString(
                R.string.price,
                item.price.toString()
            ) ?: ""
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