package com.beauty.shop.models

data class Product(
    val productName: String,
    val productDescription: String,
    val productBenefits: String,
    val oldPrice: Double,
    val newPrice: Double,
    val rating: Float,
    val reviewsCount: Int,
    val isBestSeller: Boolean,
    val isFavorite: Boolean,
    val isAddedToCart: Boolean, // New property for cart tracking
    val isInStock: Boolean,
    val productImage: Int // Drawable resource ID
)
