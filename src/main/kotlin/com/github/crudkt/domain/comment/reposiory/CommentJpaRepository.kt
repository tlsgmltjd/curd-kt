package com.github.crudkt.domain.comment.reposiory

import com.github.crudkt.domain.comment.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentJpaRepository : JpaRepository<Comment, Long>