package com.jjcdutra.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class OrderTest {

    @Test
    fun `should throw error when id is empty`() {
        val exception = assertThrows<Exception> {
            Order("", "123", listOf())
        }
        assertEquals("Id is required", exception.message)
    }

    @Test
    fun `should throw error when customerId is empty`() {
        val exception = assertThrows<Exception> {
            Order("1", "", listOf())
        }
        assertEquals("CustomerId is required", exception.message)
    }

    @Test
    fun `should throw error when items is empty`() {
        val exception = assertThrows<Exception> {
            Order("1", "1", listOf())
        }
        assertEquals("Items is required", exception.message)
    }

    @Test
    fun `should calculate total`() {
        val item = OrderItem("i1", "Item 1", BigDecimal(100))
        val order = Order("o1", "c1", listOf(item))

        assertEquals(BigDecimal(100), order.getTotal())
    }
}