package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.checkout.entity.Order
import com.jjcdutra.domain.checkout.entity.OrderItem
import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import com.jjcdutra.domain.entity.*
import com.jjcdutra.domain.product.entity.Product
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerRepository
import com.jjcdutra.infrastructure.order.repository.jpa.OrderModelRepository
import com.jjcdutra.infrastructure.order.repository.jpa.OrderRepository
import com.jjcdutra.infrastructure.product.repository.jpa.ProductModelRepository
import com.jjcdutra.infrastructure.product.repository.jpa.ProductRepository
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
        orderRepository = OrderRepository(orderModelRepository, customerModelRepository, productModelRepository)
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

        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))
        productRepository.create(product)

        val item = OrderItem(UUID.randomUUID().toString(), product.name, product.price, product.id, 2)

        val order = Order(UUID.randomUUID().toString(), customer.id, listOf(item))

        orderRepository.create(order)

        val orderModel = orderModelRepository.findById(order.id).get()

        assertNotNull(order)
        assertEquals(order.id, orderModel.id)
        assertEquals(order.customerId, orderModel.customer.id)
        assertEquals(order.total, orderModel.total)
        assertEquals(1, orderModel.items.size)
    }

    @Test
    fun should_update_an_order_when_information_an_id() {

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

        val product2 = Product(UUID.randomUUID().toString(), "Product 2", BigDecimal("20"))
        productRepository.create(product2)

        val item2 = OrderItem(UUID.randomUUID().toString(), product2.name, product2.price, product2.id, 4)

        val order2 = Order(order.id, order.customerId, listOf(item, item2))

        orderRepository.update(order2)

        val orderUpdated = orderModelRepository.findById(order.id).get()

        assertNotNull(orderUpdated)
        assertEquals(order.id, orderUpdated.id)
        assertEquals(order.customerId, orderUpdated.customer.id)
        assertEquals(BigDecimal("100.00"), orderUpdated.total)
        assertEquals(2, orderUpdated.items.size)
    }

    @Test
    fun should_find_a_order_by_informing_an_id() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("street", 1, "28640000", "city")
        customer.changeAddress(address)
        customerRepository.create(customer)

        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))
        productRepository.create(product)

        val item = OrderItem(UUID.randomUUID().toString(), product.name, product.price, product.id, 2)

        val order = Order(UUID.randomUUID().toString(), customer.id, listOf(item))

        orderRepository.create(order)

        val orderFind = orderRepository.find(order.id)

        assertNotNull(orderFind)
        assertEquals(order.id, orderFind.id)
        assertEquals(order.customerId, orderFind.customerId)
        assertEquals(order.items.size, orderFind.items.size)
    }

    @Test
    fun should_find_all_order() {
        val customer = Customer(UUID.randomUUID().toString(), "Customer")
        val address = Address("street", 1, "28640000", "city")
        customer.changeAddress(address)
        customerRepository.create(customer)

        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))
        productRepository.create(product)

        val item = OrderItem(UUID.randomUUID().toString(), product.name, product.price, product.id, 2)

        val order = Order(UUID.randomUUID().toString(), customer.id, listOf(item))

        orderRepository.create(order)

        val orderList = orderRepository.findAll()

        assertNotNull(orderList)
        assertEquals(1, orderList.size)
    }
}