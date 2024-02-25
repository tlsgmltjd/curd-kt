package com.github.crudkt.domain.feed.repository

import com.github.crudkt.domain.feed.domain.FeedEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FeedJpaRepository : JpaRepository<FeedEntity, Long> {
}