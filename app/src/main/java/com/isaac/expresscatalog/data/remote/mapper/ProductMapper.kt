package com.isaac.expresscatalog.data.remote.mapper

import com.isaac.expresscatalog.core.util.calculateScore
import com.isaac.expresscatalog.data.remote.dto.ProductDto
import com.isaac.expresscatalog.domain.model.Item

fun ProductDto.toDomain(): Item {
    val safeId = id ?: 0
    val safeTitle = title?.takeIf { it.isNotBlank() } ?: "Sin título"
    val safeDescription = description?.takeIf { it.isNotBlank() } ?: "Sin descripción"
    val safePrice = price ?: 0.0
    val safeRating = rating ?: 0.0
    val safeStock = stock ?: 0

    val safeStatus = availabilityStatus?.takeIf { it.isNotBlank() }
        ?: when {
            safeStock <= 0 -> "Sin stock"
            safeStock <= 5 -> "Stock bajo"
            else -> "Disponible"
        }

    return Item(
        id = safeId,
        title = safeTitle,
        description = safeDescription,
        price = safePrice,
        imageUrl = thumbnail.orEmpty(),
        rating = safeRating,
        stock = safeStock,
        status = safeStatus,
        score = calculateScore(
            rating = rating,
            stock = stock,
            price = price
        )
    )
}