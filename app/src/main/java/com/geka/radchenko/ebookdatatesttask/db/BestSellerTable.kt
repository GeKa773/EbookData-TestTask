package com.geka.radchenko.ebookdatatesttask.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BEST_SELLER_TABLE)
class BestSellerTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = BEST_SELLER_ID)
    val id: Int,
    @ColumnInfo(name = BEST_SELLER_IMAGE)
    val image: String,
    @ColumnInfo(name = BEST_SELLER_TITLE)
    val title: String,
    @ColumnInfo(name = BEST_SELLER_AUTHOR)
    val author: String,
    @ColumnInfo(name = BEST_SELLER_PRICE)
    val price: Float,
    @ColumnInfo(name = BEST_SELLER_RATE)
    val rate: Float,
    @ColumnInfo(name = BEST_SELLER_RATE_COUNT)
    val rateCount: Int
)

const val BEST_SELLER_TABLE = "best_seller_table"
const val BEST_SELLER_ID = "best_seller_id"
const val BEST_SELLER_IMAGE = "best_seller_image"
const val BEST_SELLER_TITLE = "best_seller_title"
const val BEST_SELLER_AUTHOR = "best_seller_author"
const val BEST_SELLER_PRICE = "best_seller_price"
const val BEST_SELLER_RATE = "best_seller_rate"
const val BEST_SELLER_RATE_COUNT = "best_seller_rate_count"