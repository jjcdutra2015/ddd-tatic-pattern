package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.product.entity.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private lateinit var repositoryModel: ProductModelRepository

    private lateinit var repository: ProductRepository

    @BeforeEach
    fun setUp() {
        repository = ProductRepository(repositoryModel)
        repositoryModel.deleteAll()
    }

    @Test
    fun `should create a product`() {
        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))

        repository.create(product)

        val productModel = repositoryModel.findById(product.id).get()

        assertNotNull(productModel)
        assertEquals(product.id, productModel.id)
        assertEquals(product.name, productModel.name)
        assertEquals(product.price, productModel.price)
    }

    @Test
    fun `should update a product`() {
        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))

        repository.create(product)

        val productModel = repositoryModel.findById(product.id).get()

        assertNotNull(productModel)

        product.changeName("Product 2")
        product.changePrice(BigDecimal("20.00"))

        repository.update(product)

        val productUpdate = repositoryModel.findById(product.id).get()

        assertNotNull(productUpdate)
        assertEquals("Product 2", productUpdate.name)
        assertEquals(BigDecimal("20.00"), productUpdate.price)
    }

    @Test
    fun `should find a product by informing an id`() {
        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))

        repository.create(product)

        val productModel = repository.find(product.id)

        assertNotNull(productModel)
    }

    @Test
    fun `should find all products`() {
        val product = Product(UUID.randomUUID().toString(), "Product", BigDecimal("10.00"))
        val product1 = Product(UUID.randomUUID().toString(), "Product 1", BigDecimal("20.00"))

        repository.create(product)
        repository.create(product1)

        val productList = repository.findAll()

        assertNotNull(productList)
        assertEquals(2, productList.size)
    }
}