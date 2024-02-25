package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.SaveFeedRequest
import com.github.crudkt.domain.feed.domain.FeedEntity
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SaveFeedService(
    private val feedJpaRepository: FeedJpaRepository
) {
    fun execute(dto: SaveFeedRequest) {
         val feedEntity = FeedEntity(
             title = dto.title,
             content = dto.content
         )

        feedJpaRepository.save(feedEntity)
    }
}