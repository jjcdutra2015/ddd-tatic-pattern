package com.jjcdutra.domain.product.entity

import java.math.BigDecimal

class ProductB(
    var id: String,
    var name: String,
    var price: BigDecimal
) : ProductInterface{
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

    fun changePrice(price: BigDecimal) {
        this.price = price
        validate()
    }

    override fun obtainId():String {
        return this.id
    }

    override fun obtainName(): String {
        return this.name
    }

    override fun obtainPrice(): BigDecimal {
        return this.price * BigDecimal(2)
    }
}
