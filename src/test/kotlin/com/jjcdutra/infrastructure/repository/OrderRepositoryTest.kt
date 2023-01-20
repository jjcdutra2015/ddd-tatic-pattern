package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.entity.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
class OrderRepositoryTest {

    @Autowired
    private lateinit var orderModelRepository: OrderModelRepository

    @Autowired
    private lateinit var customerModelRepository: CustomerModelRepository

    @Autowired
    private lateinit var productModelRepository: ProductModelRepository

    private lateinit var orderRepository: OrderRepository
    private lateinit var customerRepository: CustomerRepository
    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setUp() {
        orderRepository = OrderRepository(orderModelRepository)
        customerRepository = CustomerRepository(customerModelRepository)
        productRepository = ProductRepository(productModelRepository)
        orderModelRepository.deleteAll()
        customerModelRepository.deleteAll()
        productModelRepository.deleteAll()
    }

    @Test
    fun should_create_an_order() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("street", 1, "28640000", "city")
        customer.changeAddress(address)
        customerRepository.create(customer)

        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10"))
        productRepository.create(product)

        val item = OrderItem(UUID.randomUUID().toString(), product.name, product.price, product.id, 2)

        val order = Order(UUID.randomUUID().toString(), customer.id, listOf(item))

        orderRepository.create(order)

        val orderModel = orderModelRepository.findById(order.id).get()

        assertNotNull(order)
        assertEquals(order.id, orderModel.id)
        assertEquals(order.customerId, orderModel.customer.id)
        assertEquals(1, orderModel.items.size)
    }
}