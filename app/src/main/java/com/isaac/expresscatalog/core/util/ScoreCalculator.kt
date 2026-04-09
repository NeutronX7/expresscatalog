package com.isaac.expresscatalog.core.util

import kotlin.math.ln
import kotlin.math.max

fun calculateScore(
    rating: Double?,
    stock: Int?,
    price: Double?
): Double {
    val normalizedRating = rating ?: 0.0
    val normalizedStock = stock ?: 0
    val normalizedPrice = if (price == null || price <= 0.0) 1.0 else price

    return (normalizedRating * ln(normalizedStock + 1.0)) / max(normalizedPrice, 1.0)
}