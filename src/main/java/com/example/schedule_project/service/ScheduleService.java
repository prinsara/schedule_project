package com.example.schedule_project.service;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    //전체조회 메서드
    @Transactional(readOnly = true)
    //전체 조회 리스트로 생성, getAll()
    //작성자명 기준으로 전체조회시 getAll 매개변수 안에 작성자명 name 기재
    public List<GetScheduleResponse> getAll(String name) {

        List<Schedule> schedules;

        //작성자명이 없으면 전체 일정 조회
        //작성자 명이 없을 경우 if 문으로 name == null 인지, isBlank() 메서드를 이용하여 "", " " 이런 공백이 있는지 예외 확인을 함
        //해당과 같은 경우일 경우에
        if (name == null || name.isBlank()) {
            //Repository에 저장된 사용자 입력 값에 ModifiedAt(수정순) 내림차순으로 정렬하는 메서드 실행함
            //해당 메서드 안에 매개변수는 없음(작성자명이 없기 때문에)
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }
        //작성자명이 있으면 해당 작성자의 일정만 조회할 수 있게끔 else 사용
        //위와 같지만 다른 점은 매개변수 안에 (name)이 들어갔다는 점 해당 작성자명을 기준으로 수정순으로 정렬
        else {
            schedules = scheduleRepository.findByNameOrderByModifiedAtDesc(name);
        }

        //이렇게 상기와 같은 방법을 사용 가져온 값을 여러 개 담기 위해 빈 리스트 하나 만들어줌
        List<GetScheduleResponse> gets = new ArrayList<>();

        //향상된 for문 사용하여 응답 dto로 변환해야함 응답에 필요한 Password 제외 넣어줌
        for (Schedule schedule : schedules) {
            //schedules에 담긴 일정들을 하나씩 꺼내서 schedule에 넣어준다.
            //예를 들어 해당 일정이 5개면 5번 돌면서 하나씩 처리하게끔 만든다.
            GetScheduleResponse getDto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getScheduleName(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            //gets에 추가
            gets.add(getDto);
        }
        return gets;
    }

    //선택 조회 메서드
    public GetScheduleResponse getOne(Long ScheduleId) {
        Schedule foundSchedule = scheduleRepository.findById(ScheduleId).orElseThrow(
                () -> new IllegalMonitorStateException("선택한 일정이 존재하지 않습니다.")
        );
        return new GetScheduleResponse(
                foundSchedule.getId(),
                foundSchedule.getScheduleName(),
                foundSchedule.getContent(),
                foundSchedule.getName(),
                foundSchedule.getCreatedAt(),
                foundSchedule.getModifiedAt()
        );
    }


    //선택한 일정 수정
    //선택한 일정의 아이디, 일정 제목, 작성자명, 패스워드 매개변수로 받아옴
    public UpdateScheduleResponse update(Long id, String scheduleName, String name, String password) {
        //찾은 아이디 밑에 있는 변수에 넣어줌
        Schedule findSchedule = scheduleRepository.findById(id).orElseThrow(
                //없을 시 예외처리
                () -> new IllegalMonitorStateException("선택한 일정이 존재하지 않습니다.")
        );

        //사용자가 입력한 패스워드 == DB에 저장된 패스워드가 같은지 확인하기
        if (!findSchedule.getPassword().equals(password)) {
            //불일치시 예외처리
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        //비밀번호가 일치할 시 일정 제목, 작성자명 수정
        findSchedule.updateSchedule(scheduleName, name);

        return new UpdateScheduleResponse(
                findSchedule.getScheduleName(),
                findSchedule.getName(),
                findSchedule.getModifiedAt());
    }
}