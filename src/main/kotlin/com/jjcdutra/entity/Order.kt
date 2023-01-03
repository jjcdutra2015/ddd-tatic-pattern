package com.jjcdutra.entity

class Order(
    private val id: String,
    private val customerId: String,
    private val items: List<OrderItem> = listOf()
)