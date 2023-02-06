package com.jjcdutra.domain.product.entity

import java.math.BigDecimal

interface ProductInterface {
    fun obtainId(): String
    fun obtainName(): String
    fun obtainPrice(): BigDecimal
}