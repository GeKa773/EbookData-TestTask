package com.geka.radchenko.ebookdatatesttask.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.base.BaseFragment
import com.geka.radchenko.ebookdatatesttask.databinding.BookItemFragmentBinding
import com.geka.radchenko.ebookdatatesttask.ui.adapter.SimpleAdapter
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.BookItemViewModel
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookItemFragment : BaseFragment<BookItemFragmentBinding>(
    R.layout.book_item_fragment,
    BookItemFragmentBinding::inflate
) {
    private val TAG by lazy { javaClass.simpleName }
    private val viewModel by lazy {
        ViewModelProvider(this)[BookItemViewModel::class.java]
    }
    private val mainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    private lateinit var simpleAdapter: SimpleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.setBestSeller(BookItemFragmentArgs.fromBundle(requireArguments()).bestSeller)
        initView()
        initRvSimilar()
        observeSimilar()


    }

    private fun initRvSimilar() {
        simpleAdapter = SimpleAdapter()
        binding.rvSimilar.run {
            adapter = simpleAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initView() {
        with(binding) {
            ivBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            ivShop.setOnClickListener {

            }
        }
    }

    private fun observeSimilar() {
        viewModel.dbSimilar.observe(viewLifecycleOwner) {
            viewModel.setSimpleData(it)
        }

        viewModel.simpleDataList.observe(viewLifecycleOwner) {
            simpleAdapter.submitList(it)
        }
    }
}