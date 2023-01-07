package com.jjcdutra.domain.service

import com.jjcdutra.domain.entity.Customer
import com.jjcdutra.domain.entity.Order
import com.jjcdutra.domain.entity.OrderItem
import java.math.BigDecimal

class OrderService {
    companion object {
        fun total(orders: List<Order>): BigDecimal {
            return orders.map { it.getTotal() }.reduce { acc, totalOrders -> acc + totalOrders }
        }

        fun placeOrder(customer: Customer, items: List<OrderItem>): Order {
            if (items.isEmpty()) {
                throw Exception("Order must have at least one item")
            }
            val order = Order("id", customer.getId(), items)
            customer.addRewardPoints(order.getTotal().toInt() / 2)
            return order
        }
    }
}
