package com.puj.testtaskonlineshop.domain.models

data class Product(
    val name: String,
    val description: String,
    val rating: Double,
    val amountOfReviews: Int,
    val price: Double,
    val colors: List<String>,
    val imageUrls: List<String>
)