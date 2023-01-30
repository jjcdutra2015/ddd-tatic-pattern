package com.jjcdutra.domain.event

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EventDispatcherTest {

    @Test
    fun should_create_an_event_handler() {
        val eventDispatcher = EventDispatcher()
        val eventHandler = SendEmailWhenProductIsCreateHanlder()

        eventDispatcher.register("ProductCreateEvent", eventHandler)

        assertNotNull(eventDispatcher.getEventHanlders["ProductCreateEvent"])
        assertEquals(1, eventDispatcher.getEventHanlders.size)
    }
}