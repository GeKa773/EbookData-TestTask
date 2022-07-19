package com.geka.radchenko.ebookdatatesttask.api

import com.geka.radchenko.ebookdatatesttask.api.pojo.BestData
import com.geka.radchenko.ebookdatatesttask.api.pojo.CarouselData
import com.geka.radchenko.ebookdatatesttask.api.pojo.SimilarData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface Api {

    @GET("carousel")
    fun getCarouselAsync(): Deferred<List<CarouselData>>
    fun getBestAsync(): Deferred<List<BestData>>
    fun getSimilarAsync(): Deferred<List<SimilarData>>
}