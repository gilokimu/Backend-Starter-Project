package me.gilo.backend.delivery.rest.imp

import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.delivery.rest.api.ProductDto
import me.gilo.backend.delivery.rest.api.ProductsResource
import me.gilo.backend.delivery.rest.api.toProduct
import me.gilo.backend.delivery.rest.api.toProductDto
import me.gilo.backend.delivery.usecases.core.UseCaseExecutor
import me.gilo.backend.delivery.usecases.core.product.CreateProductUseCase
import me.gilo.backend.delivery.usecases.core.product.GetProductByIdUseCase
import me.gilo.backend.delivery.usecases.core.product.GetProductsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

class ProductResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ProductsResource {

    override fun getProductByCode(@PathVariable("code") code: String) =
        useCaseExecutor(
            useCase = getProductByIdUseCase,
            requestDto = code,
            requestConverter = { ProductCode(it) },
            responseConverter = { it.toProductDto() })

    override fun createProduct(@RequestBody productDto: ProductDto) =
        useCaseExecutor(
            useCase = createProductUseCase,
            requestDto = productDto,
            requestConverter = { it.toProduct() },
            responseConverter = { ResponseEntity<Unit>(HttpStatus.CREATED) })

    override fun getProducts() =
            useCaseExecutor(
                    useCase = getProductsUseCase,
                    requestDto = null,
                    requestConverter = {  },
                    responseConverter = { productList -> productList.map { product -> product.toProductDto() } })

}