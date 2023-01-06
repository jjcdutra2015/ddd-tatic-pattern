package com.jjcdutra.service

import com.jjcdutra.entity.Customer
import com.jjcdutra.entity.Order
import com.jjcdutra.entity.OrderItem
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class OrderServiceTest {

    @Test
    fun `should get total all of order`() {
        val item1 = OrderItem("1", "Item 1", BigDecimal(100), "p1", 1)
        val item2 = OrderItem("2", "Item 2", BigDecimal(200), "p2", 2)

        val order1 = Order("o1", "c1", listOf(item1))
        val order2 = Order("o2", "c1", listOf(item2))

        val total = OrderService.total(listOf(order1, order2))

        assertEquals(BigDecimal(500), total)
    }

    @Test
    fun `should place an order`() {
        val customer = Customer("c1", "Customer 1")
        val item = OrderItem("o1", "Item 1", BigDecimal(10), "p1", 1)

        val order = OrderService.placeOrder(customer, listOf(item))

        assertEquals(5, customer.getRewardPoints())
        assertEquals(BigDecimal(10), order.getTotal())
    }
}