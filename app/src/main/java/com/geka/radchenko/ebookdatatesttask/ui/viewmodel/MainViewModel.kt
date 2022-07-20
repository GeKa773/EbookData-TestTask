package com.geka.radchenko.ebookdatatesttask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geka.radchenko.ebookdatatesttask.api.pojo.CarouselData
import com.geka.radchenko.ebookdatatesttask.db.BestSellerTable
import com.geka.radchenko.ebookdatatesttask.repository.Repository
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter
import com.geka.radchenko.ebookdatatesttask.util.toDb
import com.geka.radchenko.ebookdatatesttask.util.toShowData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {
    private val TAG by lazy { javaClass.simpleName }

    private val _carouselList = MutableLiveData<List<CarouselData>>()
    val carouselList: LiveData<List<CarouselData>> = _carouselList

    private val _bestSellerList = MutableLiveData<List<BestSellerAdapter.BestSellerData>>()
    val bestSellerList: LiveData<List<BestSellerAdapter.BestSellerData>> = _bestSellerList

    val dbBestSeller = repository.getBestSellersLive()

    private fun getCarouselRetrofit() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.getCarouselAsync().await()
            _carouselList.value = result
        }
    }

     fun getBestSellersRetrofit() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getBestAsync().await()
            val list = arrayListOf<BestSellerTable>().apply {
                result.forEach {
                    add(it.toDb())
                }
            }
            withContext(Dispatchers.Main) {
                repository.addBestSellers(list)
            }
        }
    }

    fun setBestSellersListData(list: List<BestSellerTable>) {
        val array = arrayListOf<BestSellerAdapter.BestSellerData>().apply {
            list.forEach {
                add(it.toShowData())
            }
        }
        _bestSellerList.value = array
    }
}