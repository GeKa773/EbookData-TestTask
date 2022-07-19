package com.geka.radchenko.ebookdatatesttask.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<I>(val view: ViewDataBinding) : RecyclerView.ViewHolder(view.root) {
    abstract fun bind(position: Int, item: I)
}