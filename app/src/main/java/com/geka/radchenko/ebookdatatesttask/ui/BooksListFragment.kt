package com.geka.radchenko.ebookdatatesttask.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.base.BaseFragment
import com.geka.radchenko.ebookdatatesttask.databinding.BooksListFragmentBinding
import com.geka.radchenko.ebookdatatesttask.ui.adapter.BestSellerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.adapter.PagerAdapter
import com.geka.radchenko.ebookdatatesttask.ui.helper.HorizontalMarginItemDecoration
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

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
    private lateinit var pagerAdapter: PagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvBestSeller()
        initPagerAdapter()
        observeBestSeller()
        observePagerList()
    }

    private fun initPagerAdapter() {
        pagerAdapter = PagerAdapter()
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * abs(position))
        }
        val itemDecoration = HorizontalMarginItemDecoration(
            requireContext(),
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPager.run {
            adapter = pagerAdapter
            setPageTransformer(pageTransformer)
            addItemDecoration(itemDecoration)
        }
    }

    private fun initRvBestSeller() {
        bestSellerAdapter = BestSellerAdapter {
            binding.rvBestSeller.findNavController()
                .navigate(BooksListFragmentDirections.actionBooksListFragmentToBookItemFragment(it))
        }
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

    private fun observePagerList() {
        viewModel.dbPagerData.observe(viewLifecycleOwner) {
            viewModel.setPagerData(it)
        }
        viewModel.pagerList.observe(viewLifecycleOwner) {
            pagerAdapter.submitList(it)
        }
    }
}