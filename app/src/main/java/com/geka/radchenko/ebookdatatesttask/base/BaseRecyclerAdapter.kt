package com.geka.radchenko.ebookdatatesttask.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


abstract class BaseRecyclerAdapter<I, holder : BaseViewHolder<I>>(diffCallBack: DiffUtil.ItemCallback<I>) :
    ListAdapter<I, holder>(diffCallBack) {

    private val items = arrayListOf<I>()

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): holder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        return getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.bind(position, getItem(position))
    }

    fun getItemSize() = items.size

    fun getItemPosition(item: I) = items.indexOf(item)

    fun getItems() = items
}

