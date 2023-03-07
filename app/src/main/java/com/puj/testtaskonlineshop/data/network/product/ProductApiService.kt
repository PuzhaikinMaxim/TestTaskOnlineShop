package com.puj.testtaskonlineshop.data.network.product

import com.puj.testtaskonlineshop.data.network.models.ProductDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {

    @GET("f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getProduct(): Response<ProductDto>
}