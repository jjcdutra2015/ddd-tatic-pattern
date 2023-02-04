package com.jjcdutra.infrastructure.product.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface ProductModelRepository : JpaRepository<ProductModel, String>