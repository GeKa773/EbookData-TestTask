package com.geka.radchenko.ebookdatatesttask.ui

import androidx.appcompat.app.AppCompatActivity
import com.geka.radchenko.ebookdatatesttask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private val TAG by lazy { javaClass.simpleName }
}