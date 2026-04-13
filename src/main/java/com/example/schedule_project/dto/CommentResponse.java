package com.example.schedule_project.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {

    private final Long id;
    private final String commentContent;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long scheduleId;

    public CommentResponse(Long id, String commentContent, String name, LocalDateTime createdAt, LocalDateTime modifiedAt, Long scheduleId) {
        this.id = id;
        this.commentContent = commentContent;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.scheduleId = scheduleId;
    }
}
