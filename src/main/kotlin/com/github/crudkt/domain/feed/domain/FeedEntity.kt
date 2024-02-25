package com.github.crudkt.domain.feed.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class FeedEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val feedId: Long,
    val title: String,
    val content: String
)
