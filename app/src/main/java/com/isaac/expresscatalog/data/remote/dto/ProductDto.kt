package com.isaac.expresscatalog.data.remote.dto

data class ProductListResponseDto(
    val products: List<ProductDto>?
)

data class ProductDto(
    val id: Int?,
    val title: String?,
    val description: String?,
    val price: Double?,
    val rating: Double?,
    val stock: Int?,
    val thumbnail: String?,
    val availabilityStatus: String?
)