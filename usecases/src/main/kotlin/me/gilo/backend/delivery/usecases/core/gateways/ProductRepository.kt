package me.gilo.backend.delivery.usecases.core.gateways

import me.gilo.backend.delivery.usecases.core.product.CreateProductUseCase
import me.gilo.backend.delivery.usecases.core.product.GetProductByIdUseCase

interface ProductRepository : GetProductByIdUseCase.ProductRepository, CreateProductUseCase.ProductRepository