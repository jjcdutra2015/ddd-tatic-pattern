package com.jjcdutra.usecase.customer.create

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModel
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
class CreateCustomerTest {

    @Mock
    private lateinit var repositoryModel: CustomerModelRepository

    private lateinit var repository: CustomerRepository

    @BeforeEach
    fun setUp() {
        repository = CustomerRepository(repositoryModel)
    }

    @Test
    fun `should create a customer`() {
        val customer = Customer("123", "John")
        val address = Address("street", 1, "zip", "city")
        customer.changeAddress(address)

        val model = CustomerModel(
                customer.id,
                customer.name,
                customer.address!!.street,
                customer.address!!.number,
                customer.address!!.zip,
                customer.address!!.city,
                true,
                1
        )

        Mockito.`when`(repositoryModel.save(model))

        val input = InputCreateCustomerDto(
                "Name",
                com.jjcdutra.usecase.customer.create.Address(
                        "street",
                        1,
                        "city",
                        "zip"
                )
        )

        var output = OutputCreateCustomerDto(
                "123",
                "John",
                com.jjcdutra.usecase.customer.create.Address(
                        "street",
                        1,
                        "city",
                        "zip"
                )
        )

        val usecase = CreateCustomerUseCase(repository)

        output = usecase.execute(input)

        assertEquals(output, input)
    }
}