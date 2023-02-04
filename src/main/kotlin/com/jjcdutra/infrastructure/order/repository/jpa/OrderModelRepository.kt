package com.jjcdutra.infrastructure.order.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface OrderModelRepository : JpaRepository<OrderModel, String>