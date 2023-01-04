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
}
