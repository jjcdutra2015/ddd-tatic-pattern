package com.jjcdutra.domain.entity

import com.jjcdutra.domain.entity.Order
import com.jjcdutra.domain.entity.OrderItem
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
        val item = OrderItem("i1", "Item 1", BigDecimal(100), "p1", 2)
        val item2 = OrderItem("i1", "Item 1", BigDecimal(200), "p1", 2)
        val order = Order("o1", "c1", listOf(item, item2))

        assertEquals(BigDecimal(600), order.total)
    }

    @Test
    fun `should throw error if item qte is less or equal zero`() {
        val exception = assertThrows<Exception> {
            val item1 = OrderItem("i1", "Item 1", BigDecimal(100), "p1", 1)
            val item2 = OrderItem("i1", "Item 1", BigDecimal(100), "p1", 0)
            Order("o1", "c1", listOf(item1, item2))
        }
        assertEquals("Quantity must be greater than zero", exception.message)
    }
}