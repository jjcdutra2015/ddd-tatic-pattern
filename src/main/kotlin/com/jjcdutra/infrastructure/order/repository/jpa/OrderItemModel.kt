package com.jjcdutra.infrastructure.order.repository.jpa

import com.jjcdutra.infrastructure.product.repository.jpa.ProductModel
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

        @Column(nullable = false)
    val quantity: Int,

        @Column(nullable = false)
    val name: String,

        @Column(nullable = false)
    val price: BigDecimal
)
