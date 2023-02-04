package com.jjcdutra.domain.event

import java.time.LocalDate

interface EventInterface {
    val dateTimeOccurred: LocalDate
    val eventData: Any
}