package com.jjcdutra.infrastructure.order.repository.jpa

import com.jjcdutra.domain.checkout.entity.Order
import com.jjcdutra.domain.checkout.entity.OrderItem
import com.jjcdutra.domain.checkout.repository.OrderRepositoryInterface
import com.jjcdutra.infrastructure.customer.repository.jpa.CustomerModelRepository
import com.jjcdutra.infrastructure.product.repository.jpa.ProductModelRepository
import org.springframework.stereotype.Service

@Service
class OrderRepository(
        val repository: OrderModelRepository,
        val customerRepository: CustomerModelRepository,
        val productRepository: ProductModelRepository
) : OrderRepositoryInterface {
    override fun create(entity: Order) {
        val customerModel = customerRepository.findById(entity.customerId).get()
        val orderModel =
            OrderModel(id = entity.id, customer = customerModel, total = entity.total, items = entity.items.map {
                val productModel = productRepository.findById(it.productId).get()
                OrderItemModel(
                    it.id, productModel, it.quantity, it.name, it.price
                )
            })
        repository.save(orderModel)
    }

    override fun update(entity: Order) {
        val order = repository.findById(entity.id).get()
        val customer = customerRepository.findById(entity.customerId).get()
        val orderModel =
            order.copy(id = entity.id, customer = customer, total = entity.total, items = entity.items.map {
                val product = productRepository.findById(it.productId).get()
                OrderItemModel(
                    it.id, product, it.quantity, it.name, it.price
                )
            })
        repository.save(orderModel)
    }

    override fun find(id: String): Order {
        val orderModel = repository.findById(id).get()
        return Order(orderModel.id, orderModel.customer.id, orderModel.items.map {
            OrderItem(it.id, it.name, it.price, it.product.id, it.quantity)
        })
    }

    override fun findAll(): List<Order> {
        val orderList = repository.findAll()
        return orderList.map {
            Order(
                it.id, it.customer.id, it.items.map { item ->
                    OrderItem(
                        item.id, item.name, item.price, item.product.id, item.quantity
                    )
                }, it.total
            )
        }
    }
}
