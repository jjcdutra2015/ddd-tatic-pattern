package com.jjcdutra.domain.entity

import java.math.BigDecimal

class OrderItem(
    private val id: String,
    private val name: String,
    private val price: BigDecimal,
    private val productId: String,
    private val quantity: Int
) {
    fun getPrice(): BigDecimal {
        return this.price
    }

    fun getQuantity(): Int {
        return this.quantity
    }

    fun orderItemTotal(): BigDecimal {
        return this.price * this.quantity.toBigDecimal()
    }
}
