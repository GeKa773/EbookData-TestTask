package com.geka.radchenko.ebookdatatesttask.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.geka.radchenko.ebookdatatesttask.R
import com.geka.radchenko.ebookdatatesttask.base.BaseFragment
import com.geka.radchenko.ebookdatatesttask.databinding.BookItemFragmentBinding
import com.geka.radchenko.ebookdatatesttask.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookItemFragment : BaseFragment<BookItemFragmentBinding>(
    R.layout.book_item_fragment,
    BookItemFragmentBinding::inflate
) {
    private val TAG by lazy { javaClass.simpleName }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}