package com.geka.radchenko.ebookdatatesttask.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.geka.radchenko.ebookdatatesttask.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(repository: Repository) : ViewModel() {
    private val TAG by lazy { javaClass.simpleName }
}