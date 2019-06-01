package me.gilo.backend.delivery.usecases.core.gateways

import me.gilo.backend.delivery.usecases.core.product.*

interface ProductRepository :
        GetProductByIdUseCase.ProductRepository,
        CreateProductUseCase.ProductRepository,
        GetProductsUseCase.ProductRepository,
        UpdateProductUseCase.ProductRepository,
        DeleteProductUseCase.ProductRepository