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

    private String scheduleName;
    private String content;
    private String name;
    private String password;

    public Schedule(String scheduleName, String content, String name, String password) {
        this.scheduleName = scheduleName;
        this.content = content;
        this.name = name;
        this.password = password;
    }


    public void updateSchedule(String scheduleName, String name) {
        this.scheduleName = scheduleName;
        this.name = name;
    }


}