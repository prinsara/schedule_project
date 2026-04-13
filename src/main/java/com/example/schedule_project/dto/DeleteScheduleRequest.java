package com.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequest {

    //삭제 요청시 비밀번호 요청으로 인한 Request dto 생성
    private  String password;

}
