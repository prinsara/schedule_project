package com.example.schedule_project.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleCommentResponse {

    private final Long id;
    private final String scheduleName;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    //댓글 목록을 보여주기 위해리스트 사용
    private final List<CommentResponse> comments;

    public ScheduleCommentResponse(Long id, String scheduleName, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt, List<CommentResponse> comments) {
        this.id = id;
        this.scheduleName = scheduleName;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.comments = comments;
    }
}
