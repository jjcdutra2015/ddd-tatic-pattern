package com.jjcdutra.domain.event

class EventDispatcher : EventDispatcherInterface {

    private val eventHandlers: MutableMap<String, EventHandlerInterface<EventInterface>> = mutableMapOf()

    fun getEventHandlers(): Map<String, EventHandlerInterface<EventInterface>> {
        return eventHandlers
    }

    override fun notify(event: EventInterface) {
        val eventName = event.javaClass.simpleName
        if (this.eventHandlers[eventName] != null) {
            this.eventHandlers[eventName]?.handle(event)
        }
    }

    override fun register(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        if (this.eventHandlers[eventName] == null) {
            this.eventHandlers[eventName] = eventHandler
        }
    }

    override fun unregister(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        if (this.eventHandlers[eventName] != null) {
            this.eventHandlers.remove(eventName)
        }
    }

    override fun unregisterAll() {
        this.eventHandlers.clear()
    }
}