package com.jjcdutra.domain.event

interface EventHandlerInterface<T> : EventInterface {
    fun handle(event: T)
}