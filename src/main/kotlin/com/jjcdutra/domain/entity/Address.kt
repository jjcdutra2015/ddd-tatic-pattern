package com.jjcdutra.domain.entity

data class Address(
    val street: String,
    val number: Int,
    val zip: String,
    val city: String
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