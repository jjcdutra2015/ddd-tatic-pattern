package com.jjcdutra.domain.event.product

import com.jjcdutra.domain.event.EventInterface
import java.util.*

class ProductCreatedEvent(
    override val dataTimeOccurred: Date,
    override val eventData: Any
) : EventInterface