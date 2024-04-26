package com.github.crudkt.domain.comment.domain

import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import com.github.crudkt.domain.feed.domain.FeedEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long = 0,
    val comment: String,
    @ManyToOne(cascade = [CascadeType.ALL])
    val feed: FeedEntity
)