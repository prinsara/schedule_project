package com.example.schedule_project.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {

    private String scheduleName;
    private String content;
    private String name;
    private String password;
    //조회시 수정순으로 정렬해야하기 때문에 해당 디테일 추가
    private LocalDateTime modifiedAt;

}
