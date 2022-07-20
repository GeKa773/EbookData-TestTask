package com.geka.radchenko.ebookdatatesttask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.recyclerview.widget.DiffUtil
import com.geka.radchenko.ebookdatatesttask.base.BaseRecyclerAdapter
import com.geka.radchenko.ebookdatatesttask.base.BaseViewHolder
import com.geka.radchenko.ebookdatatesttask.databinding.ItemSimilarBinding

class SimpleAdapter :
    BaseRecyclerAdapter<SimpleAdapter.SimpleData, SimpleAdapter.SimpleHolder>(DiffCallBack) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
        return SimpleHolder(
            ItemSimilarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class SimpleHolder(private val binding: ItemSimilarBinding) :
        BaseViewHolder<SimpleData>(binding) {
        override fun bind(position: Int, item: SimpleData) {
            binding.data = item
        }

    }

    private companion object DiffCallBack : DiffUtil.ItemCallback<SimpleData>() {
        override fun areItemsTheSame(oldItem: SimpleData, newItem: SimpleData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SimpleData, newItem: SimpleData): Boolean {
            return try {
                oldItem.id == newItem.id && oldItem.image == newItem.image
            } catch (e: Exception) {
                false
            }
        }

    }

    @Keep
    data class SimpleData(val id: Int, val image: String)
}