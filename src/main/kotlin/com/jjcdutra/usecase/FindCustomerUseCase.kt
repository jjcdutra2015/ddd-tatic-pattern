package com.jjcdutra.usecase

import com.jjcdutra.domain.customer.repository.CustomerRepositoryInterface

class FindCustomerUseCase(val repository: CustomerRepositoryInterface) {
    fun execute(input: InputFindCustomerDto): OutputFindCustomerDto {
        val customer = repository.find(input.id)
        return OutputFindCustomerDto(
                customer.id,
                customer.name,
                Address(
                        customer.address!!.street,
                        customer.address!!.city,
                        customer.address!!.number,
                        customer.address!!.zip,
                )
        )
    }
}
