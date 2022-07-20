package com.geka.radchenko.ebookdatatesttask.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.base.BaseFragment
import com.geka.radchenko.ebookdatatesttask.databinding.BooksListFragmentBinding
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BooksListFragment :
    BaseFragment<BooksListFragmentBinding>(
        R.layout.books_list_fragment,
        BooksListFragmentBinding::inflate
    ) {
    private val TAG by lazy { javaClass.simpleName }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }
    private lateinit var bestSellerAdapter: BestSellerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvBestSeller()
        observeBestSeller()
        Log.i(TAG,"11111111111111111111111111111")
        viewModel.getBestSellersRetrofit()

    }

    private fun initRvBestSeller() {
        bestSellerAdapter = BestSellerAdapter { }
        binding.rvBestSeller.run {
            adapter = bestSellerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeBestSeller() {
        viewModel.dbBestSeller.observe(viewLifecycleOwner) {
            viewModel.setBestSellersListData(it)
        }

        viewModel.bestSellerList.observe(viewLifecycleOwner) {
            bestSellerAdapter.submitList(it)
        }
    }
}