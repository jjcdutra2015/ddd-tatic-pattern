package com.jjcdutra.domain.event

class EventDispatcher : EventDispatcherInterface {

    private val eventHandlers: MutableMap<String, EventHandlerInterface<EventInterface>> = mutableMapOf()

    fun getEventHandlers() : Map<String, EventHandlerInterface<EventInterface>> {
        return eventHandlers
    }

    override fun notify(event: EventInterface) {
        TODO("Not yet implemented")
    }

    override fun register(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        if (this.eventHandlers[eventName] == null) {
            this.eventHandlers[eventName] = eventHandler
        }
    }

    override fun unregister(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        TODO("Not yet implemented")
    }

    override fun unregisterAll() {
        TODO("Not yet implemented")
    }
}