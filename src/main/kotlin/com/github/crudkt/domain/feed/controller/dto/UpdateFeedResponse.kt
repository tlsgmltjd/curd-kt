package com.github.crudkt.domain.feed.controller.dto

data class UpdateFeedResponse(
    val feedId: Long,
    val title: String,
    val content: String
)