package com.jjcdutra.domain.product.event

import com.jjcdutra.domain.event.EventInterface
import java.time.LocalDate

class ProductCreatedEvent(
        override val dateTimeOccurred: LocalDate = LocalDate.now(),
        override val eventData: Any
) : EventInterface