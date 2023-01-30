package com.jjcdutra.domain.event

interface EventHandlerInterface<out T : EventInterface> {
    fun handle(event: @UnsafeVariance T)
}