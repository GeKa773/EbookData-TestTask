package com.geka.radchenko.ebookdatatesttask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.databinding.MainActivityBinding
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private val TAG by lazy { javaClass.simpleName }
}