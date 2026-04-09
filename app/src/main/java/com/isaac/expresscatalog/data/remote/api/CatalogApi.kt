package com.isaac.expresscatalog.data.remote.api

import com.isaac.expresscatalog.data.remote.dto.ProductDto
import com.isaac.expresscatalog.data.remote.dto.ProductListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApi {

    @GET("products")
    suspend fun getProducts(): ProductListResponseDto

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductDto
}