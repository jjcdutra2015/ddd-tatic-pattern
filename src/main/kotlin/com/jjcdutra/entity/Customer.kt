package com.jjcdutra.entity

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Customer(
    private val id: String,
    private var name: String,
    private var address: Address,
    private var active: Boolean = false
) {
    init {
        validate()
    }

    fun changeName(name: String) {
        this.name = name
        validate()
    }

    fun activate() {
        if (this.address.equals(null)) {
            throw Exception("Address is mandatory to activate a customer")
        }
        this.active = true
    }

    fun deactivate() {
        this.active = false
    }

    private fun validate() {
        if (this.name.isEmpty()) {
            throw Exception("Name is required")
        }
        if (this.id.isEmpty()) {
            throw Exception("Id is required")
        }
    }
}