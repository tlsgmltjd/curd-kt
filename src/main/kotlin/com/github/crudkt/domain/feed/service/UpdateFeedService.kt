package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import com.github.crudkt.domain.feed.controller.dto.UpdateFeedResponse
import com.github.crudkt.domain.feed.domain.FeedEntity
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdateFeedService(
    private val feedJpaRepository: FeedJpaRepository
) {
    fun execute(feedId: Long, dto: UpdateFeedRequest): UpdateFeedResponse {
        val foundFeed = feedJpaRepository.findByFeedId(feedId) ?: throw RuntimeException();

        val savedFeed = feedJpaRepository.save(FeedEntity(
            feedId = foundFeed.feedId,
            title = dto.title,
            content = dto.content
        ))

        return UpdateFeedResponse(
            feedId = savedFeed.feedId,
            title = savedFeed.title,
            content = savedFeed.content)
    }
}