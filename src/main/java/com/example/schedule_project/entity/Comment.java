package com.example.schedule_project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table (name = "comments")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentContent;
    private String name;
    private String password;
    private Long scheduleId;

    public Comment(String commentContent, String name, String password, Long scheduleId) {
        this.commentContent = commentContent;
        this.name = name;
        this.password = password;
        this.scheduleId = scheduleId;
    }
}
