package com.puj.testtaskonlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puj.testtaskonlineshop.databinding.FragmentHomeBinding
import com.puj.testtaskonlineshop.presentation.TestTaskOnlineShopApplication
import com.puj.testtaskonlineshop.presentation.ViewModelFactory
import com.puj.testtaskonlineshop.presentation.adapters.FlashSaleGoodsAdapter
import com.puj.testtaskonlineshop.presentation.adapters.LatestGoodsAdapter
import com.puj.testtaskonlineshop.presentation.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("Home binding not set")

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as TestTaskOnlineShopApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
        setupLatestGoodsList()
        setupFlashSaleList()
    }

    private fun setupLatestGoodsList() {
        val adapter = LatestGoodsAdapter(requireActivity())

        viewModel.latestGoods.observe(requireActivity()) {
            adapter.latestGoodsList = it
        }

        binding.rvLatest.adapter = adapter
    }

    private fun setupFlashSaleList() {
        val adapter = FlashSaleGoodsAdapter(requireActivity())

        viewModel.flashSaleGoods.observe(requireActivity()) {
            adapter.latestGoodsList = it
        }

        binding.rvFlashSale.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}