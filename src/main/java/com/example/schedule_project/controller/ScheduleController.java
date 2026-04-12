package com.example.schedule_project.controller;

import com.example.schedule_project.dto.CreateScheduleRequest;
import com.example.schedule_project.dto.CreateScheduleResponse;
import com.example.schedule_project.dto.GetScheduleResponse;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //전체조회
    @GetMapping("/schedules")
    public List<GetScheduleResponse> getAllSchedule(
            //URL에 붙어서 온 요청 파라미터 받기
            //GET/schedules?name=사라 이런 식으로 적었을 경우에
            //파람을 붙이면 해당 URL에서 name=사라를 꺼내서 메서드 안으로 넣어준다.

            //required = false -> 파라미터가 꼭 없어도 된다. 없으면 null
            //만약 true 였으면 무조건 있어야 하며, 없을 경우 에러남
            //URL에 name 요청값이 있으면 문자열로 받아서 name 변수에 넣고 없어도 에러 내지 말기
            @RequestParam(required = false) String name
            //String name 은 받을 값의 자료형을 써준 것
    ) {
        //리턴 값은 Service에서 가져온 dto 값 반환
        return scheduleService.getAll(name);
    }

}
