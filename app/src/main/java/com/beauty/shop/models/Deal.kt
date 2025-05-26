package com.beauty.shop.models

data class Deal(
    val title: String,
    val subtitle: String,
    val dateRange: String,
    val imageRes: Int // Can be replaced with URL string if using Coil
)
