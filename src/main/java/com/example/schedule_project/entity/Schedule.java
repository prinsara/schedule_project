package com.example.schedule_project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Schedule extends BaseEntity {

    //필드 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String scheduleName;
    @Column(length = 200, nullable = false)
    private String content;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;

    /**
     *
     * @param scheduleName : 일정 제목
     * @param content : 일정 내용
     * @param name : 작성자명
     * @param password : 비밀번호
     */

    public Schedule(String scheduleName, String content, String name, String password) {
        this.scheduleName = scheduleName;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    /**
     * 수정 가능한 필드만 안전하게 바꾸려고 만든 엔티티 메서드
     * @param scheduleName 일정 제목
     * @param name 작성자명
     */
    public void updateSchedule(String scheduleName, String name) {
        this.scheduleName = scheduleName;
        this.name = name;
    }


}