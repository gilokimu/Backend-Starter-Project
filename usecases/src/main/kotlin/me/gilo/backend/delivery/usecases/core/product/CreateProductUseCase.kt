package me.gilo.backend.delivery.usecases.core.product

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.delivery.usecases.core.UseCase
import me.gilo.backend.delivery.usecases.core.exceptions.ValidationException
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateProductUseCase(private val productRepository: ProductRepository) : UseCase<Product, Unit> {
    override fun execute(product: Product) {
        if (product.price < BigDecimal.ZERO)
            throw ValidationException("Produce price should not be negative")
        productRepository.save(product.copy(createdAt = LocalDateTime.now()))
    }

    interface ProductRepository {
        fun existsProductCode(productCode: ProductCode): Boolean
        fun save(product: Product)
    }
}