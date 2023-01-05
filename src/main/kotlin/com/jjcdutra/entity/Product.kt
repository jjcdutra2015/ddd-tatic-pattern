package com.jjcdutra.entity

import java.math.BigDecimal

class Product(
    private val id: String,
    private var name: String,
    private var price: BigDecimal
) {
    init {
        validate()
    }

    private fun validate(): Boolean {
        if (this.id.isEmpty()) {
            throw Exception("Id is required")
        }
        if (this.name.isEmpty()) {
            throw Exception("Name is required")
        }
        if (this.price < BigDecimal.ZERO) {
            throw Exception("Price must be greater than zero")
        }
        return true
    }

    fun changeName(name: String) {
        this.name = name
        validate()
    }

    fun getName(): String {
        return this.name
    }

    fun changePrice(price: BigDecimal) {
        this.price = price
        validate()
    }

    fun getPrice(): BigDecimal {
        return this.price
    }
}
