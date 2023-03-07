package com.puj.testtaskonlineshop.domain

import androidx.lifecycle.LiveData
import com.puj.testtaskonlineshop.domain.models.Product

interface ProductRepository {

    fun getProduct(): LiveData<Product>
}