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
    private lateinit var binding: MainActivityBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}