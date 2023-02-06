package com.jjcdutra.domain.factory

import com.jjcdutra.domain.product.entity.Product
import com.jjcdutra.domain.product.entity.ProductB
import com.jjcdutra.domain.product.factory.ProductFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProductFactoryTest {

    @Test
    fun should_create_a_product_A() {

        val productFactory = ProductFactory.create("a","Product A", BigDecimal(1))

        assertNotNull(productFactory)
        assertNotNull(productFactory.obtainId())
        assertEquals("Product A", productFactory.obtainName())
        assertEquals(BigDecimal(1), productFactory.obtainPrice())
        assertInstanceOf(Product::class.java, productFactory)
    }

    @Test
    fun should_create_a_product_B() {

        val productFactory = ProductFactory.create("b","Product B", BigDecimal(1))

        assertNotNull(productFactory)
        assertNotNull(productFactory.obtainId())
        assertEquals("Product B", productFactory.obtainName())
        assertEquals(BigDecimal(2), productFactory.obtainPrice())
        assertInstanceOf(ProductB::class.java, productFactory)
    }
}