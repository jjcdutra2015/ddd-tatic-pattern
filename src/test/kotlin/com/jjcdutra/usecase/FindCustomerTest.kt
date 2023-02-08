package com.jjcdutra.usecase

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class FindCustomerTest {

    @Autowired
    private lateinit var repositoryModel: CustomerModelRepository

    private lateinit var repository: CustomerRepository

    @BeforeEach
    fun setUp() {
        repository = CustomerRepository(repositoryModel)
        repositoryModel.deleteAll()
    }

    @Test
    fun `should find customer use case`() {
        val usecase = FindCustomerUseCase(repository)

        val customer = Customer("123", "John")
        val address = Address("street", 1, "zip", "city")
        customer.changeAddress(address)

        repository.create(customer)

        val input = InputFindCustomerDto("123")

        val output = OutputFindCustomerDto(
                "123",
                "John",
                Address(
                        "street",
                        "city",
                        1,
                        "zip"
                )
        )

        val result = usecase.execute(input)

        assertEquals(output, result)
    }
}