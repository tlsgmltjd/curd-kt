package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeleteFeedService(
    private val feedJpaRepository: FeedJpaRepository
) {
    fun execute(feedId: Long) {
        if (!feedJpaRepository.existsByFeedId(feedId))
            throw RuntimeException()

        feedJpaRepository.deleteByFeedId(feedId)
    }
}