package com.puj.testtaskonlineshop.data.network.product

import com.puj.testtaskonlineshop.data.network.models.ProductDto

interface ProductRemoteDataSource {

    suspend fun getProduct(): ProductDto
}