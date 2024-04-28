package com.github.crudkt.domain.comment.domain

import com.github.crudkt.domain.feed.domain.FeedEntity
import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType

@Entity
class Comment (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long = 0,
    val comment: String,
    @ManyToOne
    @Cascade(value = [CascadeType.ALL])
    val feed: FeedEntity
)