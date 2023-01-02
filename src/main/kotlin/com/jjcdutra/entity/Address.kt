package com.jjcdutra.entity

class Address(
    private val street: String,
    private val number: Int,
    private val zip: String,
    private val city: String
) {

    init {
        validate()
    }

    private fun validate() {
        if (this.street.isEmpty()) {
            throw Exception("Street is required")
        }
        if (this.number.equals(null)) {
            throw Exception("Number is required")
        }
        if (this.zip.isEmpty()) {
            throw Exception("Zip is required")
        }
        if (this.city.isEmpty()) {
            throw Exception("City is required")
        }
    }
}