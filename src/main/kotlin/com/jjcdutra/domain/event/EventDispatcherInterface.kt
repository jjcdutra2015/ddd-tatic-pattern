package com.jjcdutra.domain.event

interface EventDispatcherInterface {
    fun notify(event: EventInterface)
    fun register(eventName: String, eventHandler: EventHandlerInterface<EventInterface>)
    fun unregister(eventName: String, eventHandler: EventHandlerInterface<EventInterface>)
    fun unregisterAll()
}