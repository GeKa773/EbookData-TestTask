package com.geka.radchenko.ebookdatatesttask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geka.radchenko.ebookdatatesttask.api.pojo.CarouselData
import com.geka.radchenko.ebookdatatesttask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {
    private val TAG by lazy { javaClass.simpleName }
    private val _carouselList = MutableLiveData<List<CarouselData>>()
    val carouselList: LiveData<List<CarouselData>> = _carouselList

    fun getCarouselRetrofit() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.getCarouselAsync().await()
            _carouselList.value = result
        }
    }
}