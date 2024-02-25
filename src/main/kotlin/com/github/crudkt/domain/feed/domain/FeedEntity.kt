package com.github.crudkt.domain.feed.domain

import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class FeedEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val feedId: Long = 0,
    var title: String,
    var content: String
) {
    fun updateFeed(dto: UpdateFeedRequest) {
        this.title = dto.title
        this.content = dto.content
    }
}
