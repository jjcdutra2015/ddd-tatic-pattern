package com.jjcdutra.domain.product.factory

import com.jjcdutra.domain.product.entity.Product
import com.jjcdutra.domain.product.entity.ProductB
import com.jjcdutra.domain.product.entity.ProductInterface
import java.math.BigDecimal
import java.util.UUID

class ProductFactory {
    companion object {
        fun create(type: String, name: String, price: BigDecimal): ProductInterface {
            when (type) {
                "a" -> return Product(UUID.randomUUID().toString(), name, price)
                "b" -> return ProductB(UUID.randomUUID().toString(), name, price)
            }
            throw Exception("Product type is incorrect")
        }
    }
}
