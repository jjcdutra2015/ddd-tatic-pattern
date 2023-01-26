package com.jjcdutra.infrastructure.db.jpa.model

import jakarta.persistence.*
import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
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
