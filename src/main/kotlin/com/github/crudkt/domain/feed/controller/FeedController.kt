package com.github.crudkt.domain.feed.controller

import com.github.crudkt.domain.feed.controller.dto.*
import com.github.crudkt.domain.feed.service.*
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
    private val loadFeedInfoService: LoadFeedInfoService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService
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

    @GetMapping("/{feedId}")
    fun loadFeedInfo(@PathVariable("feedId") feedId: Long): ResponseEntity<LoadFeedInfoResponse> {
        return ResponseEntity.ok(loadFeedInfoService.execute(feedId));
    }

    @PatchMapping("/{feedId}")
    fun updateFeed(@PathVariable("feedId") feedId: Long,
                   @RequestBody dto: UpdateFeedRequest): ResponseEntity<UpdateFeedResponse> {
        return ResponseEntity.ok(updateFeedService.execute(feedId, dto))
    }

    @DeleteMapping("/{feedId}")
    fun deleteFeed(@PathVariable("feedId") feedId: Long): ResponseEntity<Void> {
        deleteFeedService.execute(feedId)
        return ResponseEntity.ok().build()
    }
}