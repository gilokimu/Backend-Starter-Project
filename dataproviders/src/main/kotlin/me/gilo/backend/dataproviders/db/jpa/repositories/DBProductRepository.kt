package me.gilo.backend.dataproviders.db.jpa.repositories

import me.gilo.backend.dataproviders.db.jpa.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBProductRepository : JpaRepository<ProductEntity, String>