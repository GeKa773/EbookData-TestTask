package com.geka.radchenko.ebookdatatesttask.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<VB : ViewBinding>(
    layoutId: Int,
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) :
    Fragment(layoutId) {


    private var _binding: VB? = null
    val binding: VB get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        if (_binding == null) {
            throw IllegalArgumentException("Binding cannot be null}")
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}