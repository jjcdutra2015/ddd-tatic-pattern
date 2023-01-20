package com.jjcdutra.infrastructure.repository

import com.jjcdutra.infrastructure.db.jpa.model.OrderModel
import org.springframework.data.jpa.repository.JpaRepository

interface OrderModelRepository : JpaRepository<OrderModel, String>