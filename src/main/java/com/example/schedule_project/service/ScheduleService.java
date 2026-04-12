package com.example.schedule_project.service;

import com.example.schedule_project.dto.CreateScheduleRequest;
import com.example.schedule_project.dto.CreateScheduleResponse;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    //저장메서드 만들기
    //사용자 입력 값 받아오기
    @Transactional
    public CreateScheduleResponse addSchedule(CreateScheduleRequest request) {
        //dto -> entity로 변환하기 ^^
        Schedule schedule = new Schedule(
                request.getScheduleName(),
                request.getContent(),
                request.getName(),
                request.getPassword());

        //변환한 거 저장하기 레포지토리에다가
        Schedule addSchedule = scheduleRepository.save(schedule);
        CreateScheduleResponse createResponse = new CreateScheduleResponse(
                addSchedule.getId(),
                addSchedule.getScheduleName(),
                addSchedule.getContent(),
                addSchedule.getName(),
                addSchedule.getCreatedAt(),
                addSchedule.getModifiedAt());

        return createResponse;
    }
}