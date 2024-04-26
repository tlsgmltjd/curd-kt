package com.github.crudkt.domain.comment.controller.dto

data class SaveCommentRequest (
    val feedId: Long,
    val comment: String
)