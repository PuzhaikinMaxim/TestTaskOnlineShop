package com.puj.testtaskonlineshop.data.mappers

import com.puj.testtaskonlineshop.data.network.models.ProductDto
import com.puj.testtaskonlineshop.domain.models.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() {

    fun mapProductDtoToProduct(productDto: ProductDto): Product {
        return Product(
            productDto.name,
            productDto.description,
            productDto.rating,
            productDto.numberOfReviews,
            productDto.price,
            productDto.colors,
            productDto.imageUrls
        )
    }
}