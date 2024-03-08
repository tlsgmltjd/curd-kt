package com.github.crudkt.domain.ticket.event

import com.github.crudkt.domain.ticket.domain.TicketEntity
import com.github.crudkt.domain.ticket.repository.TicketJpaRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Component
@RequiredArgsConstructor
class TicketEventListener (
    private val ticketJpaRepository: TicketJpaRepository
) {

    // TransactionalEventListener 부분 테스트 +

    @TransactionalEventListener
    fun eventListen(event: TicketEvent) {
        saveTicket(event);
    }

    @Transactional
    fun saveTicket(event: TicketEvent) {
        val ticket = TicketEntity(
            ticketContent = "짠",
            feed = event.feed
        );

        ticketJpaRepository.save(ticket);
    }
}