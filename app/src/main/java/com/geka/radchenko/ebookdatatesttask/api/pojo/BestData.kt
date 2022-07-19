package com.geka.radchenko.ebookdatatesttask.api.pojo

import androidx.annotation.Keep

@Keep
data class BestData(
    val id: Int,
    val title: String,
    val author: String,
    val price: Float,
    val image: String,
    val rate: RateData,
)

@Keep
data class RateData(
    val score: Float,
    val amount: Int
)