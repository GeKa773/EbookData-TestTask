package com.geka.radchenko.ebookdatatesttask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.base.BaseRecyclerAdapter
import com.geka.radchenko.ebookdatatesttask.base.BaseViewHolder
import com.geka.radchenko.ebookdatatesttask.databinding.ItemBestSellerBinding

class BestSellerAdapter(private val click: (item: BestSellerData) -> Unit) :
    BaseRecyclerAdapter<BestSellerAdapter.BestSellerData, BestSellerAdapter.BestSellerHolder>(
        DiffCallBack
    ) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): BestSellerHolder {
        return BestSellerHolder(
            ItemBestSellerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class BestSellerHolder(private val binding: ItemBestSellerBinding) :
        BaseViewHolder<BestSellerData>(binding) {
        init {
            binding.root.setOnClickListener {
                click.invoke(getItem(adapterPosition))
            }
        }

        override fun bind(position: Int, item: BestSellerData) {
            binding.data = item
        }

    }

    private companion object DiffCallBack : DiffUtil.ItemCallback<BestSellerData>() {
        override fun areItemsTheSame(oldItem: BestSellerData, newItem: BestSellerData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BestSellerData, newItem: BestSellerData): Boolean {
            return try {
                oldItem.id == newItem.id &&
                        oldItem.image == newItem.image &&
                        oldItem.title == newItem.title &&
                        oldItem.author == newItem.author &&
                        oldItem.price == newItem.price &&
                        oldItem.rate == newItem.rate &&
                        oldItem.rateCount == newItem.rateCount

            } catch (e: Exception) {
                false
            }
        }

    }

    @Keep
    data class BestSellerData(
        val id: Int,
        val image: String,
        val title: String,
        val author: String,
        val price: Float,
        val rate: Float,
        val rateCount: Int
    )


}