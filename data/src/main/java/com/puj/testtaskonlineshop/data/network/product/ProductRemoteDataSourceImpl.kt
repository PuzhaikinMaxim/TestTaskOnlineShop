package com.puj.testtaskonlineshop.data.network.product

import com.puj.testtaskonlineshop.data.network.models.ProductDto
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val service: ProductApiService
): ProductRemoteDataSource {

    override suspend fun getProduct(): ProductDto {
        val response = service.getProduct()
        if(response.isSuccessful){
            return response.body() ?: throw RuntimeException("Response body is null")
        }
        throw RuntimeException("Server does not responding")
    }
}