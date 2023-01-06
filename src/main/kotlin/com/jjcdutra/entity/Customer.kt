package com.jjcdutra.entity

class Customer(
    private val id: String,
    private var name: String,
    private var active: Boolean = false,
    private var rewardPoints: Int = 0
) {
    private var address: Address? = null

    fun setAddress(address: Address) {
        this.address = address
    }

    init {
        validate()
    }

    fun getId(): String = this.id

    fun getName(): String = this.name

    fun getRewardPoints(): Int = this.rewardPoints

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