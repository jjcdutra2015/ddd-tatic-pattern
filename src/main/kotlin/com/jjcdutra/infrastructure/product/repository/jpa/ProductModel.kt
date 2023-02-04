package com.jjcdutra.infrastructure.product.repository.jpa

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
data class ProductModel(

    @Id
    @Column
    val id: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: BigDecimal
)