package com.jjcdutra.domain.product.event.handler

import com.jjcdutra.domain.event.EventHandlerInterface
import com.jjcdutra.domain.product.event.ProductCreatedEvent

class SendEmailWhenProductIsCreatedHandler : EventHandlerInterface<ProductCreatedEvent> {
    override fun handle(event: ProductCreatedEvent) {
        println("Sending e-mail....")
    }
}