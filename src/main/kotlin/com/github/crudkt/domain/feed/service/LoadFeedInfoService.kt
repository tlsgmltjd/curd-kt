package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.LoadFeedInfoResponse
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LoadFeedInfoService(
    private val feedJpaRepository: FeedJpaRepository
) {

    fun execute(feedId: Long): LoadFeedInfoResponse {
        val foundFeed = feedJpaRepository.findByFeedId(feedId) ?: throw RuntimeException()

        return LoadFeedInfoResponse(
            id = foundFeed.feedId,
            title = foundFeed.title,
            content = foundFeed.content
        )
    }
}