package com.example.schedule_project.service;

import com.example.schedule_project.dto.CommentRequest;
import com.example.schedule_project.dto.CommentResponse;
import com.example.schedule_project.entity.Comment;
import com.example.schedule_project.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
@Service : 비즈니스 로직 제발 기억~.~..
@RequiredArgsConstructor : final 필드 기반 생성자 자동으로 생성해주는 것
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    public final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    //저장
    @Transactional
    public CommentResponse addComment(Long id, CommentRequest request) {

        //해당 일정이 없을 시 예외 처리
        scheduleService.findByIdOrThrow(id);

        /*
        응답 데이터를 저장하고 주기 전에 댓글 제한 10개 검증
        count >= 10 이 될 경우에 최대 댓글 작성 제한 throw new 예외처리
        commentRepository에 해당 메서드 생성
         */

        int count = commentRepository.countByScheduleId(id);
        if (count >= 10) {
            throw new IllegalArgumentException("댓글은 최대 10개까지만 작성할 수 있습니다.");
        }

        //요청 DTO -> entity로 변환해줌
        Comment comment = new Comment(
                request.getCommentContent(),
                request.getName(),
                request.getPassword(),
                id
        );

        //Repository에 변환한 걸 저장하기
        Comment addcomment = commentRepository.save(comment);

        // 응답 DTO 만들기 위해 DB에 저장된 데이터를 꺼내 DTO 만들어준다.
        return new CommentResponse(
                addcomment.getId(),
                addcomment.getCommentContent(),
                addcomment.getName(),
                addcomment.getCreatedAt(),
                addcomment.getModifiedAt(),
                addcomment.getScheduleId()
        );


    }
}
