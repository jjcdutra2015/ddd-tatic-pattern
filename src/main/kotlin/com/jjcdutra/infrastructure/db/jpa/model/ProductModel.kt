package com.jjcdutra.infrastructure.db.jpa.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
data class ProductModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: BigDecimal
)