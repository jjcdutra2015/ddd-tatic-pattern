package com.jjcdutra.domain.customer.factory

import com.jjcdutra.domain.customer.valueobject.Address
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CustomerFactoryTest {

    @Test
    fun `should create a customer`() {
        val customer = CustomerFactory.create("Julio")

        assertNotNull(customer.id)
        assertEquals("Julio", customer.name)
        assertNull(customer.address)
    }

    @Test
    fun `should create a customer with an address`() {
        val address = Address("Street", 1, "28640-000", "City")
        val customer = CustomerFactory.createWithAddress("Julio", address)

        assertNotNull(customer.id)
        assertEquals("Julio", customer.name)
        assertEquals(customer.address, address)
    }
}