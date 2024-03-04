package com.github.crudkt.domain.ticket.event

import com.github.crudkt.domain.ticket.domain.TicketEntity
import com.github.crudkt.domain.ticket.repository.TicketJpaRepository
import lombok.RequiredArgsConstructor
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class TicketEventListener (
    private val ticketJpaRepository: TicketJpaRepository
) {

    @EventListener
    fun listen(event: TicketEvent) {
        val ticket = TicketEntity(
            ticketContent = "짠",
            feed = event.feed
        );

        ticketJpaRepository.save(ticket);
    }
}