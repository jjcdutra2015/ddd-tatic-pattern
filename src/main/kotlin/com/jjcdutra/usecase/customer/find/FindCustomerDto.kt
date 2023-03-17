package com.jjcdutra.usecase.customer.find

data class InputFindCustomerDto(
        val id: String
)

data class OutputFindCustomerDto(
        val id: String,
        val name: String,
        val address: Address
)

data class Address(
        val street: String,
        val city: String,
        val number: Int,
        val zip: String
)