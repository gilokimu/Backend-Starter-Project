package me.gilo.backend.delivery.usecases.core.product

import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.delivery.usecases.core.UseCase

class DeleteProductUseCase(private val productRepository: ProductRepository) :
    UseCase<ProductCode, Unit> {

    override fun execute(code : ProductCode) =
        productRepository.delete(code)

    interface ProductRepository {
        fun delete(code : ProductCode)
    }
}