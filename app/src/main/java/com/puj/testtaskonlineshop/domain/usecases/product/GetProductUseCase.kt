package com.puj.testtaskonlineshop.domain.usecases.product

import androidx.lifecycle.LiveData
import com.puj.testtaskonlineshop.domain.ProductRepository
import com.puj.testtaskonlineshop.domain.models.Product
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(): LiveData<Product> {
        return repository.getProduct()
    }
}