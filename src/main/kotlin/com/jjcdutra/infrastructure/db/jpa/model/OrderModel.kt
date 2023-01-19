package com.jjcdutra.infrastructure.db.jpa.model

import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class OrderModel(

    @Id
    val id: String,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val items: List<OrderItemModel> = listOf(),

    @Column(nullable = false)
    val total: Int
)
