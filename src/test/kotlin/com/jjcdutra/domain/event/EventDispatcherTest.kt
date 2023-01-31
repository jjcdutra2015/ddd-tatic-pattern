package com.jjcdutra.domain.event

import com.jjcdutra.domain.event.product.handler.SendEmailWhenProductIsCreatedHandler
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EventDispatcherTest {

    @Test
    fun should_register_an_event_handler() {
        val eventDispatcher = EventDispatcher()
        val eventHandler = SendEmailWhenProductIsCreatedHandler()

        eventDispatcher.register("ProductCreatedEvent", eventHandler)

        val eventHandlers = eventDispatcher.getEventHandlers()

        assertNotNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(1, eventDispatcher.getEventHandlers().size)
        assertEquals(eventHandler, eventHandlers["ProductCreatedEvent"])
    }

    @Test
    fun should_unregister_an_event_handler() {
        val eventDispatcher = EventDispatcher()
        val eventHandler = SendEmailWhenProductIsCreatedHandler()

        eventDispatcher.register("ProductCreatedEvent", eventHandler)

        val eventHandlers = eventDispatcher.getEventHandlers()

        assertNotNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(1, eventDispatcher.getEventHandlers().size)
        assertEquals(eventHandler, eventHandlers["ProductCreatedEvent"])

        eventDispatcher.unregister("ProductCreatedEvent", eventHandler)

        assertNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(0, eventDispatcher.getEventHandlers().size)
    }
    @Test
    fun should_unregister_all_event_handler() {
        val eventDispatcher = EventDispatcher()
        val eventHandler = SendEmailWhenProductIsCreatedHandler()

        eventDispatcher.register("ProductCreatedEvent", eventHandler)

        val eventHandlers = eventDispatcher.getEventHandlers()

        assertNotNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(1, eventDispatcher.getEventHandlers().size)
        assertEquals(eventHandler, eventHandlers["ProductCreatedEvent"])

        eventDispatcher.unregisterAll()

        assertNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(0, eventDispatcher.getEventHandlers().size)
    }
}