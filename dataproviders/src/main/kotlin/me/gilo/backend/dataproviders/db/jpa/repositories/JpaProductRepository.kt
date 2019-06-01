package me.gilo.backend.dataproviders.db.jpa.repositories

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.dataproviders.db.jpa.entities.ProductEntity
import me.gilo.backend.dataproviders.db.jpa.entities.toProduct
import me.gilo.backend.dataproviders.db.jpa.entities.toProductEntity
import me.gilo.backend.delivery.usecases.core.gateways.ProductRepository
import java.util.*
import javax.transaction.Transactional

open class JpaProductRepository(private val dbProductRepository: DBProductRepository) :
    ProductRepository {
    override fun existsProductCode(productCode: ProductCode) = dbProductRepository.existsById(productCode.value)

    override fun getByProductCode(productCode: ProductCode) =
        dbProductRepository.findById(productCode.value).unwrap(ProductEntity::toProduct)

    override fun getProducts() = dbProductRepository.findAll().map { productEntity -> productEntity.toProduct()}

    @Transactional
    override fun save(product: Product) {
        dbProductRepository.save(product.toProductEntity())
    }

}





