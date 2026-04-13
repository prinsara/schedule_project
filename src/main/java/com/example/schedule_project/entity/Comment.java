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

    @Column(length = 100, nullable = false)
    private String commentContent;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Long scheduleId;

    public Comment(String commentContent, String name, String password, Long scheduleId) {
        this.commentContent = commentContent;
        this.name = name;
        this.password = password;
        this.scheduleId = scheduleId;
    }
}
