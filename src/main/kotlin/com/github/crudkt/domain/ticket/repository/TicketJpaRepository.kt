package com.github.crudkt.domain.ticket.repository

import com.github.crudkt.domain.ticket.domain.TicketEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TicketJpaRepository : JpaRepository<TicketEntity, Long> {
}