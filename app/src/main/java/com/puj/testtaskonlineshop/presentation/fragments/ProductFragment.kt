package com.puj.testtaskonlineshop.presentation.fragments

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.puj.testtaskonlineshop.domain.models.Product
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.FragmentProductBinding
import com.puj.testtaskonlineshop.presentation.TestTaskOnlineShopApplication
import com.puj.testtaskonlineshop.presentation.ViewModelFactory
import com.puj.testtaskonlineshop.presentation.viewmodels.ProductViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ProductFragment: Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding: FragmentProductBinding
        get() = _binding ?: throw RuntimeException("Product binding not set")

    private lateinit var viewModel: ProductViewModel

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
        _binding = FragmentProductBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[ProductViewModel::class.java]
        setupProductData()
        setupAddToCart()
        setOnBackPressed()
    }

    private fun setupProductData() {
        viewModel.product.observe(requireActivity()){
            setupProductImages(it)
            setupProductInfo(it)
            setupProductColors(it)
        }
    }

    private fun setupProductImages(product: Product) {
        with(binding){
            loadImage(product.imageUrls[PRODUCT_IMAGE_POSITION], ivProductImage)
            loadImage(product.imageUrls[FIRST_IMAGE_POSITION], ivProduct1)
            loadImage(product.imageUrls[SECOND_IMAGE_POSITION], ivProduct2)
            loadImage(product.imageUrls[THIRD_IMAGE_POSITION], ivProduct3)
        }
    }

    private fun setupProductInfo(product: Product) {
        with(binding){
            tvProductName.text = product.name
            tvProductDescription.text = product.description
            tvProductPrice.text = getString(R.string.price, product.price.toString())
            tvRating.text = product.rating.toString()
            tvAmountOfReviews.text = getString(
                R.string.amount_of_reviews_text,
                product.amountOfReviews
            )
        }
    }

    private fun setupProductColors(product: Product) {
        with(binding){
            setRadioButtonBackgroundTint(product.colors[0],rbColor1)
            setRadioButtonBackgroundTint(product.colors[1],rbColor2)
            setRadioButtonBackgroundTint(product.colors[2],rbColor3)
        }
    }

    private fun setRadioButtonBackgroundTint(tint: String, radioButton: RadioButton) {
        radioButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(tint))
    }

    private fun setupAddToCart() {
        viewModel.amountOfProduct.observe(requireActivity()){
            binding.tvQuantityHeader.text = getString(R.string.quantity_header_text, it)
        }

        viewModel.totalPrice.observe(requireActivity()){
            binding.tvTotalPrice.text = getString(R.string.price, it.toString())
        }

        binding.btnDecrease.setOnClickListener {
            viewModel.changeAmountOfProduct(DECREASE_BY_ONE)
        }

        binding.btnIncrease.setOnClickListener {
            viewModel.changeAmountOfProduct(INCREASE_BY_ONE)
        }
    }

    private fun loadImage(url: String, target: ImageView){
        Picasso.get().load(url).into(target)
    }

    private fun setOnBackPressed() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        private const val FIRST_IMAGE_POSITION = 0
        private const val SECOND_IMAGE_POSITION = 1
        private const val THIRD_IMAGE_POSITION = 2

        private const val PRODUCT_IMAGE_POSITION = FIRST_IMAGE_POSITION

        private const val DECREASE_BY_ONE = -1
        private const val INCREASE_BY_ONE = 1
    }
}