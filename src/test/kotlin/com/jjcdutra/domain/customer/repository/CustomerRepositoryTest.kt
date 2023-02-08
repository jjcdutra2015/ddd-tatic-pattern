package com.jjcdutra.domain.customer.repository

import com.jjcdutra.domain.customer.valueobject.Address
import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
class CustomerRepositoryTest {

    @Autowired
    private lateinit var repositoryModel: CustomerModelRepository

    private lateinit var repository: CustomerRepository

    @BeforeEach
    fun setUp() {
        repository = CustomerRepository(repositoryModel)
        repositoryModel.deleteAll()
    }

    @Test
    fun `should create a customer`() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("Rua a", 1, "28640000", "A")
        customer.changeAddress(address)
        customer.activate()

        repository.create(customer)

        val customerModel = repositoryModel.findById(customer.id).get()

        assertNotNull(customerModel)
        assertEquals(customer.id, customerModel.id)
        assertEquals(customer.name, customerModel.name)
        assertEquals(customer.address!!.street, customerModel.street)
        assertEquals(customer.address!!.number, customerModel.number)
        assertEquals(customer.address!!.zip, customerModel.zip)
        assertEquals(customer.address!!.city, customerModel.city)
        assertEquals(customer.active, customerModel.active)
        assertEquals(customer.rewardPoints, customerModel.rewardPoints)
    }

    @Test
    fun `should update a customer`() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("Rua a", 1, "28640000", "A")
        customer.changeAddress(address)
        customer.activate()

        repository.create(customer)

        val customerModel = repositoryModel.findById(customer.id).get()

        assertNotNull(customerModel)

        customer.changeName("Customer 2")
        customer.addRewardPoints(1)

        repository.update(customer)

        val customerUpdate = repositoryModel.findById(customer.id).get()

        assertNotNull(customer)
        assertEquals(customerModel.id, customerUpdate.id)
        assertEquals("Customer 2", customerUpdate.name)
        assertEquals(1, customerUpdate.rewardPoints)
    }

    @Test
    fun `should find a customer by informing an id`() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("Rua a", 1, "28640000", "A")
        customer.changeAddress(address)
        customer.activate()

        repository.create(customer)

        val customerModel = repository.find(customer.id)

        assertNotNull(customerModel)
        assertEquals(customer.id, customerModel.id)
        assertEquals(customer.name, customerModel.name)
        assertEquals(customer.address!!.street, customerModel.address!!.street)
        assertEquals(customer.address!!.number, customerModel.address!!.number)
        assertEquals(customer.address!!.zip, customerModel.address!!.zip)
        assertEquals(customer.address!!.city, customerModel.address!!.city)
        assertEquals(customer.active, customerModel.active)
        assertEquals(customer.rewardPoints, customerModel.rewardPoints)
    }

    @Test
    fun `should find all customer`() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("Rua a", 1, "28640000", "A")
        customer.changeAddress(address)
        customer.activate()

        val customer2 = Customer(UUID.randomUUID().toString(), "Customer")
        val address2 = Address("Rua a", 1, "28640000", "A")
        customer2.changeAddress(address2)
        customer2.activate()

        repository.create(customer)
        repository.create(customer2)

        val customers = repository.findAll()

        assertNotNull(customers)
        assertEquals(2, customers.size)
    }
}