package com.jjcdutra.domain.event

import com.jjcdutra.domain.event.product.handler.SendEmailWhenProductIsCreatedHandler
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EventDispatcherTest {

    @Test
    fun should_create_an_event_handler() {
        val eventDispatcher = EventDispatcher()
        val eventHandler = SendEmailWhenProductIsCreatedHandler()

        eventDispatcher.register("ProductCreatedEvent", eventHandler)

        val eventHandlers = eventDispatcher.getEventHandlers()


        assertNotNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(1, eventDispatcher.getEventHandlers().size)
    }
}