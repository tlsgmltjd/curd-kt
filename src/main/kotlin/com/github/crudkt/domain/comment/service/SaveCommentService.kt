package com.github.crudkt.domain.comment.service

import com.github.crudkt.domain.comment.controller.dto.SaveCommentRequest
import com.github.crudkt.domain.comment.domain.Comment
import com.github.crudkt.domain.comment.reposiory.CommentJpaRepository
import com.github.crudkt.domain.feed.repository.FeedJpaRepository
import org.springframework.stereotype.Service

@Service
class SaveCommentService (
    private val commentJpaRepository: CommentJpaRepository,
    private val feedJpaRepository: FeedJpaRepository
) {
    fun execute(saveCommentRequest: SaveCommentRequest) {
        commentJpaRepository.save(
            Comment(
                comment = saveCommentRequest.comment,
                feed = feedJpaRepository.findByFeedId(saveCommentRequest.feedId)
                    ?: throw RuntimeException()
            )
        )
    }
}