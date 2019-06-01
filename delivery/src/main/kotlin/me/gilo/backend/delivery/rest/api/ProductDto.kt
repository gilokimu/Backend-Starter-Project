package me.gilo.backend.delivery.rest.api

import me.gilo.backend.core.entities.Product
import me.gilo.backend.core.entities.ProductCode
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ProductDto(
        var code: String,
        val description: String,
        val price: String,
        val createdAt: String? = null
)

// Mappers
fun Product.toProductDto() =
    ProductDto(
        code = this.code.value,
        description = this.description,
        price = this.price.toString(),
        createdAt = this.createdAt?.format(DateTimeFormatter.ISO_DATE_TIME)
    )

fun ProductDto.toProduct() =
    Product(
        code = ProductCode(this.code),
        description = this.description,
        price = BigDecimal(this.price),
        createdAt = if (this.createdAt == null) null else LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(this.createdAt))
    )