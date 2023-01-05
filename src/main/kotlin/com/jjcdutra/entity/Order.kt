package com.jjcdutra.entity

import java.math.BigDecimal

class Order(
    private val id: String,
    private val customerId: String,
    private val items: List<OrderItem> = listOf(),
    private var total: BigDecimal = BigDecimal.ZERO
) {

    init {
        validate()
        this.total = total()
    }

    fun getTotal(): BigDecimal {
        return this.total
    }

    private fun total(): BigDecimal {
        return items.map { it.price }.reduce { acc, price -> acc + price }
    }

    private fun validate(): Boolean {
        if (this.id.isEmpty()) {
            throw Exception("Id is required")
        }
        if (this.customerId.isEmpty()) {
            throw Exception("CustomerId is required")
        }
        if (this.items.isEmpty()) {
            throw Exception("Items is required")
        }
        return true
    }
}