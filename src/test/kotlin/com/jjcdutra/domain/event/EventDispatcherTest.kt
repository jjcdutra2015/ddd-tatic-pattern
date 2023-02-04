package com.jjcdutra.domain.event

import com.jjcdutra.domain.event.product.ProductCreatedEvent
import com.jjcdutra.domain.event.product.handler.SendEmailWhenProductIsCreatedHandler
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

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

    @Test
    fun should_notify_all_event_handler() {
        val eventDispatcher = EventDispatcher()

//        val eventHandler = Mockito.mock(SendEmailWhenProductIsCreatedHandler::class.java)

        val eventHandler = mock<SendEmailWhenProductIsCreatedHandler> {}

        eventDispatcher.register("ProductCreatedEvent", eventHandler)

        val eventHandlers = eventDispatcher.getEventHandlers()

        assertNotNull(eventHandlers["ProductCreatedEvent"])
        assertEquals(1, eventDispatcher.getEventHandlers().size)
        assertEquals(eventHandler, eventHandlers["ProductCreatedEvent"])

        val productCreatedEvent = ProductCreatedEvent(
                eventData = mapOf("name" to "Product1", "description" to "Descrição", "price" to "10.00")
        )

        eventDispatcher.notify(productCreatedEvent)

        verify(eventHandler, times(1)).handle(productCreatedEvent)
    }
}