package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.SaveFeedRequest
import com.github.crudkt.domain.feed.domain.FeedEntity
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import com.github.crudkt.domain.ticket.event.TicketEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaveFeedService(
    private val feedJpaRepository: FeedJpaRepository,
    private val publisher: ApplicationEventPublisher
) {

    @Transactional
    fun execute(dto: SaveFeedRequest) {
         val feedEntity = FeedEntity(
             title = dto.title,
             content = dto.content
         )

        val savedFeedEntity = feedJpaRepository.save(feedEntity)

        eventPublish(savedFeedEntity);
    }

    private fun eventPublish(savedFeedEntity: FeedEntity) {
        publisher.publishEvent(TicketEvent(savedFeedEntity))

    }
}