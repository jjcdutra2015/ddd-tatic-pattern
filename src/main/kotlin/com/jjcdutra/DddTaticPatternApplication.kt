package com.jjcdutra

import com.jjcdutra.entity.Address
import com.jjcdutra.entity.Customer
import com.jjcdutra.entity.Order
import com.jjcdutra.entity.OrderItem
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.math.BigDecimal

@SpringBootApplication
class DddTaticPatternApplication

fun main(args: Array<String>) {
    runApplication<DddTaticPatternApplication>(*args)

    val address = Address("Rua dois", 2, "28640-000", "Carmo")
    val customer = Customer("123", "Julio Dutra", address)
    customer.activate()

    val item1 = OrderItem("1", "Item 1", BigDecimal(10))
    val item2 = OrderItem("2", "Item 2", BigDecimal(15))
    val order = Order("1", "123", listOf(item1, item2))
}
