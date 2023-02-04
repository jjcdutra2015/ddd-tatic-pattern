package com.jjcdutra.domain.event

import java.time.LocalDate

interface EventInterface {
    val dataTimeOccurred: LocalDate
    val eventData: Any
}