package com.isaac.expresscatalog.domain.model

data class Item(
    val id: Int,
    val title: String,
    val price: Double,
    val imageUrl: String,
    val rating: Double,
    val stock: Int,
    val status: String,
    val score: Double,
    val description: String = ""
)
