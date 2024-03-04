package com.github.crudkt.domain.feed.domain

import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import com.github.crudkt.domain.ticket.domain.TicketEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class FeedEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val feedId: Long = 0,
    var title: String,
    var content: String,
    @OneToOne(mappedBy = "feed")
    val ticket: TicketEntity
) {
    fun updateFeed(dto: UpdateFeedRequest) {
        this.title = dto.title
        this.content = dto.content
    }
}