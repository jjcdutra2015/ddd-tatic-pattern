package com.jjcdutra.usecase.customer.find

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModel
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
class FindCustomerTest {

    @Mock
    private lateinit var repositoryModel: CustomerModelRepository

    private lateinit var repository: CustomerRepository

    @BeforeEach
    fun setUp() {
        repository = CustomerRepository(repositoryModel)
    }

    @Test
    fun `should find customer use case`() {
        val customer = Customer("123", "John")
        val address = Address("street", 1, "zip", "city")
        customer.changeAddress(address)

        Mockito.`when`(repositoryModel.findById("123")).thenReturn(Optional.of(
                CustomerModel(customer.id,
                        customer.name,
                        customer.address!!.street,
                        customer.address!!.number,
                        customer.address!!.zip,
                        customer.address!!.city,
                        true,
                        1
                )
        ))

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

        val usecase = FindCustomerUseCase(repository)

        val result = usecase.execute(input)

        assertEquals(output, result)
    }

    @Test
    fun `should throw error when customer not found`() {

        val exception = assertThrows<Exception> {
            repository.find("1")
        }

        assertEquals("Customer not found", exception.message)
    }
}