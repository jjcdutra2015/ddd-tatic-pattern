package com.jjcdutra.domain.customer.factory

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.customer.valueobject.Address
import java.util.*

class CustomerFactory {
    companion object {
        fun create(name: String): Customer {
            return Customer(UUID.randomUUID().toString(), name)
        }

        fun createWithAddress(name: String, address: Address): Customer {
            val customer = Customer(UUID.randomUUID().toString(), name)
            customer.changeAddress(address)
            return customer
        }
    }
}