package com.isaac.expresscatalog.data.repository

import com.isaac.expresscatalog.data.remote.api.CatalogApi
import com.isaac.expresscatalog.data.remote.mapper.toDomain
import com.isaac.expresscatalog.domain.model.Item
import com.isaac.expresscatalog.domain.repository.CatalogRepository

class CatalogRepositoryImpl(
    private val api: CatalogApi
) : CatalogRepository {

    override suspend fun getItems(): Result<List<Item>> {
        return try {
            val response = api.getProducts()
            val items = response.products
                .orEmpty()
                .map { it.toDomain() }
                .sortedByDescending { it.score }

            Result.success(items)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getItemById(id: Int): Result<Item> {
        return try {
            val item = api.getProductById(id).toDomain()
            Result.success(item)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}