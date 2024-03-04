package com.github.crudkt.domain.ticket.event

import lombok.RequiredArgsConstructor
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
@RequiredArgsConstructor
class TicketEventListener {

    @EventListener
    fun listen() {

    }

}