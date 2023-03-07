package com.puj.testtaskonlineshop.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puj.testtaskonlineshop.domain.usecases.product.GetProductUseCase
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
): ViewModel() {

    val product = getProductUseCase()

    private val _amountOfProduct = MutableLiveData(0)
    val amountOfProduct: LiveData<Int>
        get() = _amountOfProduct

    private val _totalPrice = MutableLiveData(0.0)
    val totalPrice: LiveData<Double>
        get() = _totalPrice

    fun changeAmountOfProduct(amount: Int) {
        if((_amountOfProduct.value?.plus(amount) ?: 0) < 0){
            return
        }
        _amountOfProduct.value = _amountOfProduct.value?.plus(amount)
        val amountOfProduct = _amountOfProduct.value?.toDouble() ?: 0.0
        val price = product.value?.price ?: 0.0
        _totalPrice.value = amountOfProduct * price
    }
}