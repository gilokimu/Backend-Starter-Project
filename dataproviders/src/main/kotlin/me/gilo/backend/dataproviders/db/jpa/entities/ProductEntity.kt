package me.gilo.backend.dataproviders.db.jpa.entities

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    val code: String,
    val description: String,
    val price: BigDecimal,
    val createdAt: Long
)

// Mappers
fun ProductEntity.toProduct() =
    Product(
        code = ProductCode(this.code),
        description = this.description,
        price = this.price,
        createdAt = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.createdAt), ZoneId.systemDefault())
    )

fun Product.toProductEntity() =
    ProductEntity(
        code = this.code.value,
        description = this.description,
        price = this.price,
        createdAt = this.createdAt!!.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )