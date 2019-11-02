package com.sjj.eventlistener.repository;

import com.sjj.eventlistener.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 邵少 on 2019/11/2.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
