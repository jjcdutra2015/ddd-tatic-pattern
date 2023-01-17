package com.jjcdutra.domain.entity

data class Customer(
    val id: String,
    var name: String,
    var active: Boolean = false,
    var rewardPoints: Int = 0,
    var address: Address? = null
) {

    fun changeAddress(address: Address) {
        this.address = address
    }

    init {
        validate()
    }

    fun changeName(name: String) {
        this.name = name
        validate()
    }

    fun activate() {
        if (address == null) {
            throw Exception("Address is mandatory to activate a customer")
        }
        this.active = true
    }

    fun deactivate() {
        this.active = false
    }

    private fun validate() {
        if (this.id.isEmpty()) {
            throw Exception("Id is required")
        }
        if (this.name.isEmpty()) {
            throw Exception("Name is required")
        }
    }

    fun isActive(): Boolean {
        return this.active
    }

    fun addRewardPoints(point: Int) {
        this.rewardPoints += point
    }
}