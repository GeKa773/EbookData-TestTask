package com.geka.radchenko.ebookdatatesttask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geka.radchenko.ebookdatatesttask.db.SimilarTable
import com.geka.radchenko.ebookdatatesttask.repository.Repository
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.adapter.SimpleAdapter
import com.geka.radchenko.ebookdatatesttask.util.toDb
import com.geka.radchenko.ebookdatatesttask.util.toShowData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookItemViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {
    private val TAG by lazy { javaClass.simpleName }

    init {
        getSimulatorRetrofit()
    }

    private val _bestSeller = MutableLiveData<BestSellerAdapter.BestSellerData>()
    val bestSeller: LiveData<BestSellerAdapter.BestSellerData> = _bestSeller

    private val _simpleDataList = MutableLiveData<List<SimpleAdapter.SimpleData>>()
    val simpleDataList: LiveData<List<SimpleAdapter.SimpleData>> = _simpleDataList

    val dbSimilar = repository.getSimilarLive()

    fun setBestSeller(data: BestSellerAdapter.BestSellerData) {
        _bestSeller.value = data
    }

    private fun getSimulatorRetrofit() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.getSimilarAsync().await()
            val list = arrayListOf<SimilarTable>().apply {
                result.forEach {
                    add(it.toDb())
                }
            }
            repository.addSimilar(list)
        }
    }

    fun setSimpleData(list: List<SimilarTable>) {
        val array = arrayListOf<SimpleAdapter.SimpleData>().apply {
            list.forEach {
                add(it.toShowData())
            }
        }
        _simpleDataList.value = array
    }

    fun buy(){

    }

    fun free(){

    }

}