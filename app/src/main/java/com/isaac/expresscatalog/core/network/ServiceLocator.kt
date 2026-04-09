package com.isaac.expresscatalog.core.network

import com.isaac.expresscatalog.data.repository.CatalogRepositoryImpl
import com.isaac.expresscatalog.domain.repository.CatalogRepository

object ServiceLocator {
    val catalogRepository: CatalogRepository by lazy {
        CatalogRepositoryImpl(NetworkModule.catalogApi)
    }
}