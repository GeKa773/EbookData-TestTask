package com.geka.radchenko.ebookdatatesttask.repository

import com.geka.radchenko.ebookdatatesttask.api.Api
import com.geka.radchenko.ebookdatatesttask.db.BestSellerTable
import com.geka.radchenko.ebookdatatesttask.db.DataBase
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(
    private val api: Api,
    private val dataBase: DataBase,
) {

    fun getCarouselAsync() = api.getCarouselAsync()
    fun getBestAsync() = api.getBestAsync()
    fun getSimilarAsync() = api.getSimilarAsync()


    fun getBestSellersLive() = dataBase.bestSellerDao().getBestSellersLive()
    suspend fun addBestSellers(list: List<BestSellerTable>) {
        dataBase.bestSellerDao().upsertAll(list)
    }

}