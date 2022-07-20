package com.geka.radchenko.ebookdatatesttask.util

import com.geka.radchenko.ebookdatatesttask.api.pojo.BestData
import com.geka.radchenko.ebookdatatesttask.api.pojo.CarouselData
import com.geka.radchenko.ebookdatatesttask.api.pojo.SimilarData
import com.geka.radchenko.ebookdatatesttask.db.BestSellerTable
import com.geka.radchenko.ebookdatatesttask.db.PagerDataTable
import com.geka.radchenko.ebookdatatesttask.db.SimilarTable
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.adapter.PagerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.adapter.SimpleAdapter

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

fun CarouselData.toDb(): PagerDataTable {
    return PagerDataTable(id = id, image = image)
}

fun PagerDataTable.toShowData(): PagerAdapter.PagerData {
    return PagerAdapter.PagerData(id = id, image = image)
}

fun SimilarData.toDb(): SimilarTable {
    return SimilarTable(id = id, image = image)
}

fun SimilarTable.toShowData(): SimpleAdapter.SimpleData {
    return SimpleAdapter.SimpleData(id = id, image = image)
}