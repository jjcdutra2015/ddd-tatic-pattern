package com.jjcdutra.entity

class Customer(
    private val id: String,
    private var name: String,
    private var address: String,
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
        if (this.address.isEmpty()) {
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