package me.gilo.backend.delivery.usecases.core.product

import me.gilo.backend.core.entities.Product
import me.gilo.backend.delivery.usecases.core.UseCase
import me.gilo.backend.delivery.usecases.core.exceptions.EmptyException
import me.gilo.backend.delivery.usecases.core.gateways.ProductRepository

class GetProductsUseCase(private val productRepository: ProductRepository) :
    UseCase<Unit, List<Product>> {

    override fun execute(request: Unit) =
        productRepository.getProducts() ?: throw EmptyException("No products for code")

    interface ProductRepository {
        fun getProducts(): List<Product>?
    }
}