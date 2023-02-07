package com.jjcdutra.domain.checkout.factory

import com.jjcdutra.domain.checkout.entity.Order
import com.jjcdutra.domain.checkout.entity.OrderItem

class OrderFactory {
    companion object {
        fun create(orderProps: OrderProps): Order {
            return Order(orderProps.id,
                    orderProps.customerId,
                    orderProps.items.map {
                        OrderItem(
                                it.id,
                                it.name,
                                it.price,
                                it.productId,
                                it.quantity
                        )
                    }
            )
        }
    }
}