package com.jjcdutra.infrastructure.repository

import com.jjcdutra.domain.entity.Order
import com.jjcdutra.domain.repository.OrderRepositoryInterface
import org.springframework.stereotype.Service

@Service
class OrderRepository(
    val repository: OrderModelRepository
) : OrderRepositoryInterface {
    override fun create(entity: Order) {
        TODO("Not yet implemented")
    }

    override fun update(entity: Order) {
        TODO("Not yet implemented")
    }

    override fun find(id: String): Order {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Order> {
        TODO("Not yet implemented")
    }

}
