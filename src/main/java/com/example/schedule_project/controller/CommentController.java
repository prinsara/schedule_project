package com.example.schedule_project.controller;

import com.example.schedule_project.dto.CommentRequest;
import com.example.schedule_project.dto.CommentResponse;
import com.example.schedule_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules/{id}/comments")
public class CommentController {

    private final CommentService commentService;

    //댓글 저장
    @PostMapping
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long id, @RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.addComment(id, request));
    }

}
