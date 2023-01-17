package com.jjcdutra.infrastructure.repository

import com.jjcdutra.infrastructure.db.jpa.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository

interface ProductModelRepository : JpaRepository<ProductModel, String>