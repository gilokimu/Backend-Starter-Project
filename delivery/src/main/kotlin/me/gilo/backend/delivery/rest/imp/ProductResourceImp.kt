package me.gilo.backend.delivery.rest.imp

import me.gilo.backend.core.entities.ProductCode
import me.gilo.backend.delivery.rest.api.ProductDto
import me.gilo.backend.delivery.rest.api.ProductsResource
import me.gilo.backend.delivery.rest.api.toProduct
import me.gilo.backend.delivery.rest.api.toProductDto
import me.gilo.backend.delivery.usecases.core.UseCaseExecutor
import me.gilo.backend.delivery.usecases.core.product.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.CompletionStage

class ProductResourceImp(
    private val useCaseExecutor: UseCaseExecutor,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val createProductUseCase: CreateProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) : ProductsResource {
    override fun updateProduct(code: String, productDto: ProductDto): CompletionStage<ProductDto> {
        productDto.code = code
        return useCaseExecutor(
                useCase = updateProductUseCase,
                requestDto = productDto,
                requestConverter = { it.toProduct() },
                responseConverter = { it.toProductDto() }
        )

    }

    override fun deleteProduct(@PathVariable("code") code: String): CompletionStage<ResponseEntity<Unit>>  =
            useCaseExecutor(
                    useCase = deleteProductUseCase,
                    requestDto = code,
                    requestConverter = {ProductCode(it)},
                    responseConverter = { ResponseEntity<Unit>(HttpStatus.OK) })

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