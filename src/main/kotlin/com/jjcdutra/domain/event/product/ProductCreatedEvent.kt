package com.jjcdutra.domain.event.product

import com.jjcdutra.domain.event.EventInterface
import java.time.LocalDate

class ProductCreatedEvent(
    override val dataTimeOccurred: LocalDate = LocalDate.now(),
    override val eventData: Any
) : EventInterface