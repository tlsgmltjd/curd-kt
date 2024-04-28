package com.github.crudkt.domain.comment.controller

import com.github.crudkt.domain.comment.controller.dto.SaveCommentRequest
import com.github.crudkt.domain.comment.service.SaveCommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comments")
class CommentController (
    private val saveCommentService: SaveCommentService
) {
    @PostMapping("/{feedId}")
    fun saveComment(@RequestBody dto: SaveCommentRequest, @PathVariable feedId: Long): ResponseEntity<Void> {
        saveCommentService.execute(dto, feedId)
        return ResponseEntity.ok().build()
    }
}