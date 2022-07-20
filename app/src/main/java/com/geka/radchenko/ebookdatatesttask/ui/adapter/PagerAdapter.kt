package com.geka.radchenko.ebookdatatesttask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.recyclerview.widget.DiffUtil
import com.geka.radchenko.ebookdatatesttask.base.BaseRecyclerAdapter
import com.geka.radchenko.ebookdatatesttask.base.BaseViewHolder
import com.geka.radchenko.ebookdatatesttask.databinding.ItemPagerBinding

class PagerAdapter :
    BaseRecyclerAdapter<PagerAdapter.PagerData, PagerAdapter.PagerHolder>(DiffCallBack) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        return PagerHolder(
            ItemPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class PagerHolder(private val binding: ItemPagerBinding) :
        BaseViewHolder<PagerData>(binding) {
        override fun bind(position: Int, item: PagerData) {
            binding.data = item
        }

    }

    private companion object DiffCallBack : DiffUtil.ItemCallback<PagerData>() {
        override fun areItemsTheSame(oldItem: PagerData, newItem: PagerData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PagerData, newItem: PagerData): Boolean {
            return try {
                oldItem.id == newItem.id &&
                        oldItem.image == newItem.image
            } catch (e: Exception) {
                false
            }
        }

    }

    @Keep
    data class PagerData(val id: Int, val image: String)


}