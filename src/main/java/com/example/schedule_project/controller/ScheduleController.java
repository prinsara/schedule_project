package com.example.schedule_project.controller;

import com.example.schedule_project.dto.CreateScheduleRequest;
import com.example.schedule_project.dto.CreateScheduleResponse;
import com.example.schedule_project.repository.ScheduleRepository;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    //저장
    @PostMapping("/schedules")
    //보여줘야 돼 뭘 보여줘야 돼?!?!?!?!! 응답 메서드 만들기
    //요청이 온 거를
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
    //서비스에서 만든 메서드 활용 사용자에게 보여주기
       CreateScheduleResponse createResult = scheduleService.addSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createResult);
    }
}
