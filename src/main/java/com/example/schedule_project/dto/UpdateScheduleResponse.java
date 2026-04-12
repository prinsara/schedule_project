package com.example.schedule_project.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {

    private final String scheduleName;
    private final String name;

    public UpdateScheduleResponse(String scheduleName, String name) {
        this.scheduleName = scheduleName;
        this.name = name;
    }
}
