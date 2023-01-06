package com.jjcdutra.service

import com.jjcdutra.entity.Order
import java.math.BigDecimal

class OrderService {
    companion object {
        fun total(orders: List<Order>): BigDecimal {
            return orders.map { it.getTotal() }.reduce { acc, totalOrders -> acc + totalOrders }
        }
    }

}
