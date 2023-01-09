package com.jjcdutra.domain.service

import com.jjcdutra.domain.entity.Product
import com.jjcdutra.domain.service.ProductService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProductServiceTest {

    @Test
    fun `should change the price of all products`() {
        val product1 = Product("p1", "Product 1", BigDecimal(10))
        val product2 = Product("p2", "Product 2", BigDecimal(20))

        val products = listOf(product1, product2)

        ProductService.increasePrice(products, 100)

        assertEquals(BigDecimal(20), product1.getPrice())
        assertEquals(BigDecimal(40), product2.getPrice())
    }
}