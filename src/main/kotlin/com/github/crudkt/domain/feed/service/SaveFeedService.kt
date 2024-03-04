package com.github.crudkt.domain.feed.service

import com.github.crudkt.domain.feed.controller.dto.SaveFeedRequest
import com.github.crudkt.domain.feed.domain.FeedEntity
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import com.github.crudkt.domain.ticket.event.TicketEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SaveFeedService(
    private val feedJpaRepository: FeedJpaRepository,
    private val publisher: ApplicationEventPublisher
) {
    fun execute(dto: SaveFeedRequest) {
         val feedEntity = FeedEntity(
             title = dto.title,
             content = dto.content
         )

        val savedFeedEntity = feedJpaRepository.save(feedEntity)

        publish(savedFeedEntity);
    }

    private fun publish(savedFeedEntity: FeedEntity) {
        publisher.publishEvent(TicketEvent(savedFeedEntity))
    }
}