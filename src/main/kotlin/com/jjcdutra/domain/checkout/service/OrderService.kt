package com.jjcdutra.domain.checkout.service

import com.jjcdutra.domain.customer.entity.Customer
import com.jjcdutra.domain.checkout.entity.Order
import com.jjcdutra.domain.checkout.entity.OrderItem
import java.math.BigDecimal

class OrderService {
    companion object {
        fun total(orders: List<Order>): BigDecimal {
            return orders.map { it.total }.reduce { acc, totalOrders -> acc + totalOrders }
        }

        fun placeOrder(customer: Customer, items: List<OrderItem>): Order {
            if (items.isEmpty()) {
                throw Exception("Order must have at least one item")
            }
            val order = Order("id", customer.id, items)
            customer.addRewardPoints(order.total.toInt() / 2)
            return order
        }
    }
}
