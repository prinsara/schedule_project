package com.example.schedule_project.controller;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;


    //저장
    @PostMapping
    //보여줘야 돼 뭘 보여줘야 돼?!?!?!?!! 응답 메서드 만들기
    //요청이 온 거를
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        //서비스에서 만든 메서드 활용 사용자에게 보여주기
       return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.addSchedule(request));
    }

    /*

    메서드 밖으로 주석 빼버렸어용! 그
    URL에 붙어서 온 요청 파라미터 받기
    GET/schedules?name=사라 이런 식으로 적었을 경우에
    파람을 붙이면 해당 URL에서 name=사라를 꺼내서 메서드 안으로 넣어준다.

    required = false -> 파라미터가 꼭 없어도 된다. 없으면 null
    만약 true 였으면 무조건 있어야 하며, 없을 경우 에러남
    URL에 name 요청값이 있으면 문자열로 받아서 name 변수에 넣고 없어도 에러 내지 말기
    String name 은 받을 값의 자료형을 써준 것

  */
    //전체조회
    @GetMapping
    public ResponseEntity<List<GetScheduleResponse>> getAllSchedule(
            @RequestParam(required = false) String name
    ) {
        //리턴 값은 Service에서 가져온 dto 값 반환
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll(name));
    }

    //선택 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<GetScheduleResponse> getOneSchedule(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(id, request.getScheduleName(), request.getName(), request.getPassword()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestBody DeleteScheduleRequest request) {
        scheduleService.delete(id,request.getPassword());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
