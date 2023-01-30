package com.jjcdutra.domain.event

import java.util.*

interface EventInterface {
    val dataTimeOccurred: Date
    val eventData: Any
}