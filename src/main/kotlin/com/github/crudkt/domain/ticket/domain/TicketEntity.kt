package com.github.crudkt.domain.ticket.domain

import com.github.crudkt.domain.feed.domain.FeedEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class TicketEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ticketId: Long = 0,
    val ticketContent: String,
    @OneToOne
    val feed: FeedEntity
)