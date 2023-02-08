package com.jjcdutra.domain.customer.entity

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomerTest() {

    @Test
    fun `should throw error when id is empty`() {
        val exception = assertThrows<Exception> {
            Customer("", "name")
        }

        assertEquals("Id is required", exception.message)
    }

    @Test
    fun `should throw error when name is empty`() {
        val exception = assertThrows<Exception> {
            Customer("1", "")
        }

        assertEquals("Name is required", exception.message)
    }

    @Test
    fun `should change name`() {
        val customer = Customer("1", "Julio")
        customer.changeName("Jose")

        assertEquals("Jose", customer.name)
    }

    @Test
    fun `should activate customer`() {
        val customer = Customer("1", "Julio")
        val address = Address("street", 1, "12345-123", "city")
        customer.changeAddress(address)
        customer.activate()

        assertTrue(customer.isActive())
    }

    @Test
    fun `should deactivate customer`() {
        val customer = Customer("1", "Julio")
        customer.deactivate()

        assertFalse(customer.isActive())
    }

    @Test
    fun `should throw error when address is undefined when you activate a customer`() {
        val exception = assertThrows<Exception> {
            val customer = Customer("1", "Julio")
            customer.activate()
        }

        assertEquals("Address is mandatory to activate a customer", exception.message)
    }

    @Test
    fun `should add reward points`() {
        val customer = Customer("c1", "Customer 1")
        assertEquals(0, customer.rewardPoints)

        customer.addRewardPoints(10)
        assertEquals(10, customer.rewardPoints)

        customer.addRewardPoints(10)
        assertEquals(20, customer.rewardPoints)
    }
}