package com.puj.testtaskonlineshop.presentation.fragments

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ItemDelegate<I, H : RecyclerView.ViewHolder> {

    fun itemType(): Class<out I>

    fun createViewHolder(parent: ViewGroup): H

    fun bindView(holder: RecyclerView.ViewHolder, position: Int)
}