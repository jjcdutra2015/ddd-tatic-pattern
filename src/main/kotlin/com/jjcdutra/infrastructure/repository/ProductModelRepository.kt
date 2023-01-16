package com.jjcdutra.infrastructure.repository

import com.jjcdutra.infrastructure.db.jpa.model.ProductModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductModelRepository : CrudRepository<ProductModel, String>