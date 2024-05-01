package com.github.crudkt.domain.comment.domain

import com.github.crudkt.domain.feed.domain.FeedEntity
import jakarta.persistence.*

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long = 0,
    val comment: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    val feed: FeedEntity
)