package com.jjcdutra.infrastructure.db.jpa.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "customers")
data class CustomerModel(

    @Id
    @Column
    val id: String,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val number: Int,

    @Column(nullable = false)
    val zip: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    var active: Boolean,

    @Column(nullable = false)
    var rewardPoints: Int
)