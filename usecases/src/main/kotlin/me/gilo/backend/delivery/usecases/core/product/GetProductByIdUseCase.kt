package me.gilo.backend.delivery.usecases.core.product

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.delivery.usecases.core.UseCase
import me.gilo.backend.delivery.usecases.core.exceptions.NotFoundException

class GetProductByIdUseCase(private val productRepository: ProductRepository) :
    UseCase<ProductCode, Product> {
    override fun execute(productCode: ProductCode) =
        productRepository.getByProductCode(productCode) ?: throw NotFoundException("No product for code: $productCode")

    interface ProductRepository {
        fun getByProductCode(productCode: ProductCode): Product?
    }
}