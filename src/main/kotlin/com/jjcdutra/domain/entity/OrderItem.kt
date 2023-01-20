package com.jjcdutra.domain.entity

import java.math.BigDecimal

class OrderItem(
    val id: String,
    val name: String,
    val price: BigDecimal,
    val productId: String,
    val quantity: Int
) {
    fun orderItemTotal(): BigDecimal {
        return this.price * this.quantity.toBigDecimal()
    }
}
