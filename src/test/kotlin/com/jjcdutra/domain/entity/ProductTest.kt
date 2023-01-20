package com.jjcdutra.domain.entity

import com.jjcdutra.domain.entity.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class ProductTest {

    @Test
    fun `should throw error when id is empty`() {
        val exception = assertThrows<Exception> {
            Product("", "Product", BigDecimal(10))
        }
        assertEquals("Id is required", exception.message)
    }

    @Test
    fun `should throw error when name is empty`() {
        val exception = assertThrows<Exception> {
            Product("1", "", BigDecimal(10))
        }
        assertEquals("Name is required", exception.message)
    }

    @Test
    fun `should throw error when price less than zero`() {
        val exception = assertThrows<Exception> {
            Product("1", "Product", BigDecimal.valueOf(-1))
        }
        assertEquals("Price must be greater than zero", exception.message)
    }

    @Test
    fun `should change name`() {
        val product = Product("1", "Product", BigDecimal(100))
        product.changeName("Prd")

        assertEquals("Prd", product.name)
    }

    @Test
    fun `should change price`() {
        val product = Product("1", "Product", BigDecimal(100))
        product.changePrice(BigDecimal(150))

        assertEquals(BigDecimal(150), product.price)
    }
}