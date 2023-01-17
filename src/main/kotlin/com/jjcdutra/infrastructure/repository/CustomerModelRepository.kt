package com.jjcdutra.infrastructure.repository

import com.jjcdutra.infrastructure.db.jpa.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerModelRepository : JpaRepository<CustomerModel, String>