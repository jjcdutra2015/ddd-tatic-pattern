package com.jjcdutra.domain.checkout.factory

import java.math.BigDecimal

data class OrderProps(
        val id: String,
        val customerId: String,
        val items: List<OrderItemProps>
)

data class OrderItemProps(
        val id: String,
        val name: String,
        val productId: String,
        val quantity: Int,
        val price: BigDecimal
)
