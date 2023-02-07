package com.jjcdutra.domain.checkout.factory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

class OrderFactoryTest {

    @Test
    fun `should create an order`() {
        val orderProps = OrderProps(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                listOf(OrderItemProps(
                        UUID.randomUUID().toString(),
                        "Product 1",
                        UUID.randomUUID().toString(),
                        1,
                        BigDecimal(100)
                ))
        )

        val order = OrderFactory.create(orderProps)

        assertEquals(orderProps.id, order.id)
        assertEquals(orderProps.customerId, order.customerId)
        assertEquals(1, orderProps.items.size)
    }
}