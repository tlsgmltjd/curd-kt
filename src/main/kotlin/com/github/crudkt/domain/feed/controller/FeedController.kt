package com.github.crudkt.domain.feed.controller

import com.github.crudkt.domain.feed.controller.dto.SaveFeedRequest
import com.github.crudkt.domain.feed.service.SaveFeedService
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feeds")
class FeedController(
    private val saveFeedService: SaveFeedService
) {

    @PostMapping
    fun saveFeed(@RequestBody dto: SaveFeedRequest): ResponseEntity<Void> {
        saveFeedService.execute(dto);
        return ResponseEntity.status(CREATED).build();
    }
}