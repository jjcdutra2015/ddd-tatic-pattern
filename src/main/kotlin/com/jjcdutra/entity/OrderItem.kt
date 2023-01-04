package com.jjcdutra.entity

import java.math.BigDecimal

class OrderItem(
    private val id: String,
    private val name: String,
    val price: BigDecimal
)
