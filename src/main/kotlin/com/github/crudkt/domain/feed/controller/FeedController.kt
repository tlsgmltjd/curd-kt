package com.github.crudkt.domain.feed.controller

import com.github.crudkt.domain.feed.controller.dto.LoadFeedResponse
import com.github.crudkt.domain.feed.controller.dto.SaveFeedRequest
import com.github.crudkt.domain.feed.controller.dto.UpdateFeedRequest
import com.github.crudkt.domain.feed.controller.dto.UpdateFeedResponse
import com.github.crudkt.domain.feed.service.LoadFeedService
import com.github.crudkt.domain.feed.service.SaveFeedService
import com.github.crudkt.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feeds")
class FeedController(
    private val saveFeedService: SaveFeedService,
    private val loadFeedService: LoadFeedService,
    private val updateFeedService: UpdateFeedService
) {

    @PostMapping
    fun saveFeed(@RequestBody dto: SaveFeedRequest): ResponseEntity<Void> {
        saveFeedService.execute(dto)
        return ResponseEntity.status(CREATED).build()
    }

    @GetMapping
    fun loadFeed(): ResponseEntity<List<LoadFeedResponse>> {
        return ResponseEntity.ok(loadFeedService.execute())
    }

    @PatchMapping("/{feedId}")
    fun updateFeed(@PathVariable("feedId") feedId: Long,
                   @RequestBody dto: UpdateFeedRequest): ResponseEntity<UpdateFeedResponse> {
        return ResponseEntity.ok(updateFeedService.execute(feedId, dto))
    }
}