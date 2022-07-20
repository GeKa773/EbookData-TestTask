package com.geka.radchenko.ebookdatatesttask.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.geka.radchenko.ebookdatatesttask.db.BEST_SELLER_TABLE
import com.geka.radchenko.ebookdatatesttask.db.BestSellerTable

@Dao
abstract class BestSellerDao : BaseDao<BestSellerTable>() {
    @Query("SELECT * FROM $BEST_SELLER_TABLE")
    abstract fun getBestSellersLive(): LiveData<List<BestSellerTable>>
}