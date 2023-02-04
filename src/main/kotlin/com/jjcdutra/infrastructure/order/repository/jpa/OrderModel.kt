package com.jjcdutra.infrastructure.order.repository.jpa

import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModel
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "orders")
data class OrderModel(

        @Id
    val id: String,

        @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    var items: List<OrderItemModel> = listOf(),

        @Column(nullable = false)
    var total: BigDecimal
)
