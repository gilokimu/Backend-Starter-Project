package me.gilo.backend.delivery.rest.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage
import javax.validation.Valid

@RestController
@RequestMapping("/products")
interface ProductsResource {
    @GetMapping("/{code}")
    fun getProductByCode(@PathVariable("code") code: String): CompletionStage<ProductDto>

    @GetMapping("/")
    fun getProducts(): CompletionStage<List<ProductDto>>

    @PostMapping("/create")
    fun createProduct(@Valid @RequestBody productDto: ProductDto): CompletionStage<ResponseEntity<Unit>>

    @PutMapping("/{code}")
    fun updateProduct(
            @PathVariable("code") code: String,
            @Valid @RequestBody productDto: ProductDto): CompletionStage<ProductDto>

    @DeleteMapping("/{code}")
    fun deleteProduct(@PathVariable("code") code: String): CompletionStage<ResponseEntity<Unit>>
}