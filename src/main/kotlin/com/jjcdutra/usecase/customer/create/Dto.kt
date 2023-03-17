package com.jjcdutra.usecase.customer.create

data class InputCreateCustomerDto(
        val name: String,
        val address: Address
)

data class OutputCreateCustomerDto(
        val id: String,
        val name: String,
        val address: Address
)

data class Address(
        val street: String,
        val number: Int,
        val zip: String,
        val city: String
)
