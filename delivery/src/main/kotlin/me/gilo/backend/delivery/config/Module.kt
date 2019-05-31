package me.gilo.backend.delivery.config

import me.gilo.backend.dataproviders.db.jpa.repositories.DBProductRepository
import me.gilo.backend.dataproviders.db.jpa.repositories.JpaProductRepository
import me.gilo.backend.delivery.rest.imp.ProductResourceImp
import me.gilo.backend.delivery.usecases.core.UseCaseExecutor
import me.gilo.backend.delivery.usecases.core.UseCaseExecutorImp
import me.gilo.backend.delivery.usecases.core.gateways.ProductRepository
import me.gilo.backend.delivery.usecases.core.product.CreateProductUseCase
import me.gilo.backend.delivery.usecases.core.product.GetProductByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {
    @Bean
    fun productsResourceImp(
        useCaseExecutor: UseCaseExecutor,
        getProductByIdUseCase: GetProductByIdUseCase,
        createProductUseCase: CreateProductUseCase
    ) = ProductResourceImp(useCaseExecutor, getProductByIdUseCase, createProductUseCase)

    @Bean
    fun useCaseExecutor() = UseCaseExecutorImp()

    @Bean
    fun getProductByIdUseCase(productRepository: ProductRepository) = GetProductByIdUseCase(productRepository)

    @Bean
    fun createProductUseCase(productRepository: ProductRepository) = CreateProductUseCase(productRepository)

    @Bean
    fun productRepository(dbProductRepository: DBProductRepository) = JpaProductRepository(dbProductRepository)
}