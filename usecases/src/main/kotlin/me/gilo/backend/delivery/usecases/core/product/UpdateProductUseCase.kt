package me.gilo.backend.delivery.usecases.core.product

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.core.entities.ProductData
import me.gilo.backend.delivery.usecases.core.UseCase
import me.gilo.backend.delivery.usecases.core.exceptions.EmptyException
import me.gilo.backend.delivery.usecases.core.gateways.ProductRepository

class UpdateProductUseCase(private val productRepository: ProductRepository) :
    UseCase<Product, Product> {

    override fun execute(product: Product) =
        productRepository.update(product.code, product) ?: throw EmptyException("No products for code")

    interface ProductRepository {
        fun update(code: ProductCode, product: Product): Product?
    }
}