package com.jjcdutra.entity

import java.math.BigDecimal

class Order(
    private val id: String,
    private val customerId: String,
    private val items: List<OrderItem> = listOf(),
    private var total: BigDecimal = BigDecimal.ZERO
) {
    init {
        this.total = total()
    }
    private fun total(): BigDecimal {
        return items.map { it.price }.reduce { acc, price -> acc + price }
    }
}