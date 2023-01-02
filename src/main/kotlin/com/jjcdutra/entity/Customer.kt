package com.jjcdutra.entity

class Customer(
    val id: String,
    private var name: String,
    private var address: String,
    private var active: Boolean = true
) {

    fun changeName(name: String) {
        this.name = name
    }

    fun activate() {
        this.active = true
    }

    fun deactivate() {
        this.active = false
    }
}