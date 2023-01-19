package com.jjcdutra.infrastructure.db.jpa.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "order_items")
data class OrderItemModel(

    @Id
    val id: String,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: ProductModel,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: OrderModel,

    @Column(nullable = false)
    val quantity: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: BigDecimal
)
