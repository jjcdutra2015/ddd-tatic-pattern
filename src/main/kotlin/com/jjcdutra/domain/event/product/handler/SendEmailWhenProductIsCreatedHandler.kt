package com.jjcdutra.domain.event.product.handler

import com.jjcdutra.domain.event.EventHandlerInterface
import com.jjcdutra.domain.event.product.ProductCreatedEvent

class SendEmailWhenProductIsCreatedHandler : EventHandlerInterface<ProductCreatedEvent> {
    override fun handle(event: ProductCreatedEvent) {
        println("Sending e-mail....")
    }
}