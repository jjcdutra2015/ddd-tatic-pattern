package com.jjcdutra.domain.product.service

import com.jjcdutra.domain.product.entity.Product

class ProductService {
    companion object {
        fun increasePrice(products: List<Product>, percentage: Int) {
            products.forEach { product ->
                product.changePrice((product.price * percentage.toBigDecimal()) / 100.toBigDecimal() + product.price)
            }
        }
    }
}
