package com.jjcdutra.domain.service

import com.jjcdutra.domain.entity.Product

class ProductService {
    companion object {
        fun increasePrice(products: List<Product>, percentage: Int) {
            products.forEach { product ->
                product.changePrice((product.getPrice() * percentage.toBigDecimal()) / 100.toBigDecimal() + product.getPrice())
            }
        }
    }
}