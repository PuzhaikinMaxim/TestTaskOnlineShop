package com.puj.testtaskonlineshop.data.network.models

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val name: String,
    val description: String,
    val rating: Double,
    @SerializedName("number_of_reviews")
    val numberOfReviews: Int,
    val price: Double,
    val colors: List<String>,
    @SerializedName("image_urls")
    val imageUrls: List<String>
)