package com.jjcdutra.infrastructure.customer.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerModelRepository : JpaRepository<CustomerModel, String>