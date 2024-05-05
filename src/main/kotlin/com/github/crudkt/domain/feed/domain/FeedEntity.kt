package com.github.crudkt.domain.feed.domain

import com.github.crudkt.domain.comment.domain.Comment
import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import com.github.crudkt.domain.ticket.domain.TicketEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import lombok.Builder

@Entity
class FeedEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val feedId: Long = 0,
    val title: String,
    val content: String,
    @OneToMany(mappedBy = "feed", cascade = [CascadeType.ALL])
    val comments: MutableList<Comment> = ArrayList()
)