package com.geka.radchenko.ebookdatatesttask.util

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.geka.radchenko.ebookdatatesttask.R


@SuppressLint("SetTextI18n")
@BindingAdapter("android:setPrice")
fun setPrice(view: TextView, price: Float) {
    view.text = "$price €"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("android:setRateCount")
fun setRateCount(view: TextView, rateCount: Int) {
    view.text = "($rateCount)"
}

@BindingAdapter("android:load")
fun ImageView.load(url: String?) {
    if (url == null) {
        this.setImageResource(R.drawable.load_background)
        return
    }
    Glide
        .with(this.context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.load_background)
        .into(this)
}