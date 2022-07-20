package com.geka.radchenko.ebookdatatesttask.util

import com.geka.radchenko.ebookdatatesttask.api.pojo.BestData
import com.geka.radchenko.ebookdatatesttask.db.BestSellerTable
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter

fun BestSellerTable.toShowData(): BestSellerAdapter.BestSellerData {
    return BestSellerAdapter.BestSellerData(
        id = id,
        image = image,
        title = title,
        author = author,
        price = price,
        rate = rate,
        rateCount = rateCount
    )
}

fun BestData.toDb(): BestSellerTable {
    return BestSellerTable(
        id = id,
        image = image,
        title = title,
        author = author,
        price = price,
        rate = rate.score,
        rateCount = rate.amount
    )
}