package com.jjcdutra.domain.event

class EventDispatcher : EventDispatcherInterface {
    override fun notify(event: EventInterface) {
        TODO("Not yet implemented")
    }

    override fun register(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        TODO("Not yet implemented")
    }

    override fun unregister(eventName: String, eventHandler: EventHandlerInterface<EventInterface>) {
        TODO("Not yet implemented")
    }

    override fun unregisterAll() {
        TODO("Not yet implemented")
    }
}