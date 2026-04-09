package com.isaac.expresscatalog.domain.repository

import com.isaac.expresscatalog.domain.model.Item

interface CatalogRepository {
    suspend fun getItems(): Result<List<Item>>
    suspend fun getItemById(id: Int): Result<Item>
}