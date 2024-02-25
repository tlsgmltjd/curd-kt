package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.LoadFeedResponse
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LoadFeedService(
    private val feedJpaRepository: FeedJpaRepository
) {
    fun execute(): List<LoadFeedResponse> = feedJpaRepository.findAll()
            .map { feed -> LoadFeedResponse(
                id = feed.feedId,
                title = feed.title,
                content = feed.content
            ) };
}