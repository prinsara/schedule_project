package com.example.schedule_project.repository;

import com.example.schedule_project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    /*
    개수를 세는 메서드를 만들기
    해당 scheduleId로 몇 개 있는지 count
     */

    int countByScheduleId(Long scheduleId);

}
